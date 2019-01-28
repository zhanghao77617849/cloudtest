package com.saloa.forward.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saloa.forward.entity.Person;
import com.saloa.forward.service.PersonService;

@RestController
@RequestMapping("/test")
public class TestHandler {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/save")
	public Person save() {
		Person person=new Person(null,"zhangsan","wuhan");
		return personService.save(person);
		
	}

}
