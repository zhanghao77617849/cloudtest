package com.saloa.forward.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saloa.forward.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
