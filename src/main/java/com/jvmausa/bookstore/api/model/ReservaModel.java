package com.jvmausa.bookstore.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservaModel extends RepresentationModel<ReservaModel> {

	private Long id;

	private OffsetDateTime dataReserva;
	private OffsetDateTime dataDevolucaoPrev;
	private OffsetDateTime dataDevolucao;
	
	private BigDecimal valorFinal;

	private String status;

	private LivroModel livro;

	private Boolean atraso;

}
