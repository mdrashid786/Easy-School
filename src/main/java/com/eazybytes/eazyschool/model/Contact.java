package com.eazybytes.eazyschool.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
@Data annotation is provided by Lombok library which generates getter, setter,
equals(), hashCode(), toString() methods & Constructor at compile time.
This makes our code short and clean.
* */
@Entity
@Table(name="contact_msg")
public class Contact extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "contact_id")
    private int contactId;

    /*
    * @NotNull: Checks if a given field is not null but allows empty values & zero elements inside collections.
      @NotEmpty: Checks if a given field is not null and its size/length is greater than zero.
      @NotBlank: Checks if a given field is not null and trimmed length is greater than zero.
    * */
    @NotBlank(message="Name must not be blank")
    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    @NotBlank(message="Mobile number must not be blank")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String mobileNum;

    @NotBlank(message="Email must not be blank")
    @Email(message = "Please provide a valid email address" )
    private String email;

    @NotBlank(message="Subject must not be blank")
    @Size(min=5, message="Subject must be at least 5 characters long")
    private String subject;

    @NotBlank(message="Message must not be blank")
    @Size(min=10, message="Message must be at least 10 characters long")
    private String message;

    private String status;

	public int getContactId() {
		return contactId;
	}

	public String getName() {
		return name;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public String getEmail() {
		return email;
	}

	public String getSubject() {
		return subject;
	}

	public String getMessage() {
		return message;
	}

	public String getStatus() {
		return status;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
