package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@RequestMapping(value="/student", method=RequestMethod.GET)
	public Student create() {
		
        Student.Name name = new Student.Name("Yamini", "Rawat");

        Student.Address address = new Student.Address("123", "Main Street", "Toronto");

        // Create Student object
        Student s1 = new Student("S101", "123-456-7890", "1995-08-01", name, address);
		
        return s1;
	}

}