package com.jvmausa.bookstore.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvmausa.bookstore.domain.repository.BookRepository;

@RestController
@RequestMapping(path = "/books")
public class BookController {

	@Autowired
	BookRepository bookRepository;
	
	
	@GetMapping
	public String listar() {
		return "Hello";

	}

}
