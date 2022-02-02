package com.jvmausa.bookstore.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservaModel extends RepresentationModel<ReservaModel> {

	private Long id;

	private OffsetDateTime dataReserva;
	private OffsetDateTime dataDevolucao;
	private BigDecimal valorTotal;

	private String status;

	private ClienteModel cliente;
	
	private List<ItemReservaModel> livros;

}
