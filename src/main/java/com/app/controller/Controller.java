package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.IService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
public class Controller {
	
	private final IService rest;
	
	@GetMapping("/user")
	public Object getAll() {
		
		Object users= rest.getAll();
		System.out.println(users);
		return users;
		
	}
	
	@GetMapping("/user/{id}")
	public Object getId(@PathVariable int id) {
		Object users=  rest.getFindById(id);
		return users;
		
	}

}
