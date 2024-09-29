package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Person;
import com.eazybytes.eazyschool.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("public")
public class PublicController {

    @Autowired
    PersonService personService;

    @RequestMapping(value ="/register",method = { RequestMethod.GET})
    public String displayRegisterPage(Model model) {
        model.addAttribute("person", new Person());
        return "register";
    }

//    @RequestMapping(value ="/createUser",method = { RequestMethod.POST})
//    public String createUser(@Valid @ModelAttribute("person") Person person, BindingResult errors) {
//        if(errors.hasErrors()){
//        	System.out.println("Error :"+errors);
//            return "register";
//        }
//        boolean isSaved = personService.createNewPerson(person);
//        if(isSaved){
//            return "redirect:/login?register=true";
//        }else {
//            return "register";
//        }
//    }
    
    @RequestMapping(value ="/createUser",method = { RequestMethod.POST})
    public String createUser(@Valid @ModelAttribute("person") Person person, BindingResult errors) {
        if(errors.hasErrors()){
        	System.out.println("Error :"+errors);
            return "register";
        }
       
        personService.createNewPerson(person);
        System.out.println("Error :"+errors);
            return "redirect:/login?register=true";
    }

}
