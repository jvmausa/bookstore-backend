package com.jvmausa.bookstore.api.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteModel extends RepresentationModel<ClienteModel> {

	private Long id;
	private String nome;

}
