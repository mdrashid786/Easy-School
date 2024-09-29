package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.constants.EazySchoolConstants;
import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.model.Person;
import com.eazybytes.eazyschool.model.Roles;
import com.eazybytes.eazyschool.repository.ContactRepository;
import com.eazybytes.eazyschool.repository.PersonRepository;
import com.eazybytes.eazyschool.repository.RolesRepository;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Transactional // Ensure this method is transactional
    public boolean createNewPerson(Person person) {
        // Fetch the role from the repository
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        
        if (role != null) {
            // Set the fetched role to the person
            person.setRoles(role);
            // Encode the password
            person.setPwd(passwordEncoder.encode(person.getPwd()));
            // Save the person entity
            person = personRepository.save(person); // Use save to persist the person
            return person.getPersonId() != null; // Check if saved successfully
        }
        return false; // Role not found, handle as needed
    }



//    public boolean createNewPerson(Person person){
//        boolean isSaved = false;
//        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
//        person.setRoles(role);
//        person.setPwd(passwordEncoder.encode(person.getPwd()));
//        System.out.println("Hello role :"+role.getRoleName());
//        person = personRepository.save(person);
//        if (null != person && person.getPersonId() > 0)
//        {
//        	System.out.println("Hello role :"+role.getRoleName());
//            isSaved = true;
//        }
//        return isSaved;
//    }
    
//    public void createNewPerson(Person person){
//        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
//        person.setRoles(role);
//        System.out.println("Hello role :"+role.getRoleName());
//        //person.setPwd(passwordEncoder.encode(person.getPwd()));
//        personRepository.save(person);
//       
//    }
}
