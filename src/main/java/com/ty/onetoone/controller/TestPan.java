package com.ty.onetoone.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetoone.dto.Pan;
import com.ty.onetoone.dto.Person;

public class TestPan {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Pan p = new Pan();
		p.setPanNumber("AEKP1234");
		p.setDate(LocalDate.now());
		p.setContry("India");
		
		Person person = new Person();
		person.setName("Omkar");
		person.setPhone(9561);
		person.setGender("Male");
		
		p.setPerson(person);
		
		entityTransaction.begin();
		entityManager.persist(p);
		entityManager.persist(person);
		entityTransaction.commit();
	}
}
