package com.jvmausa.bookstore.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteInput {

	@NotBlank
	private String nome;
	
}
