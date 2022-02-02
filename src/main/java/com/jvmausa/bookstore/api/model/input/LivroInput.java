package com.jvmausa.bookstore.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LivroInput {

	@NotBlank
	private String nome;

	@NotBlank
	private String autor;

	@NotBlank
	private String editora;
	
	@NotBlank
	private String preco;

}
