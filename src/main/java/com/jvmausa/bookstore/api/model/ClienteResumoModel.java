package com.jvmausa.bookstore.api.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteResumoModel extends RepresentationModel<ClienteResumoModel> {

	private Long id;

	private ReservaModel reserva;

}
