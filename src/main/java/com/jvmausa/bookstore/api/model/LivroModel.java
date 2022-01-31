package com.jvmausa.bookstore.api.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LivroModel extends RepresentationModel<LivroModel>{

	private Long id;

	private String nome;
	private String autor;
	private String editora;
	
}
