package com.jvmausa.bookstore.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvmausa.bookstore.api.assembler.ReservaModelAssembler;
import com.jvmausa.bookstore.api.model.ReservaModel;
import com.jvmausa.bookstore.domain.model.Reserva;
import com.jvmausa.bookstore.domain.repository.ReservaRepository;
import com.jvmausa.bookstore.domain.service.CadastroReservaService;

@RequestMapping(path = "/reserve")
@RestController
public class ReservaController {

	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	private ReservaModelAssembler reservaModelassembler;

	@Autowired
	private CadastroReservaService cadastroReserva;

	@GetMapping
	public CollectionModel<ReservaModel> listar() {
		return reservaModelassembler.toCollectionModel(reservaRepository.findAll());

	}

	@GetMapping(path = "/{id}")
	public ReservaModel buscar(@PathVariable Long id) {

		Reserva reserva = cadastroReserva.buscarOuFalhar(id);

		ReservaModel reservaModel = reservaModelassembler.toModel(reserva);
		return reservaModel;

	}

}
