package com.saloa.forward.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saloa.forward.dao.PersonRepository;
import com.saloa.forward.entity.Person;
import com.saloa.forward.exception.BusinessException;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person save(Person person) {
		if (null==person) {
			throw new BusinessException("11111");
		}
		Person person2=personRepository.save(person);
		return person2;
		
	}

}
