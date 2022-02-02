package com.jvmausa.bookstore.api.model;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemReservaModel extends RepresentationModel<ItemReservaModel> {

	private Long livroId;

	private String livroNome;

	private BigDecimal precoLivro;

}
