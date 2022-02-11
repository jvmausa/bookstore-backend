package com.jvmausa.bookstore.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvmausa.bookstore.domain.exception.EntidadeNaoEncontradaException;
import com.jvmausa.bookstore.domain.exception.ReservaNaoEncontradaEmClienteException;
import com.jvmausa.bookstore.domain.model.Cliente;
import com.jvmausa.bookstore.domain.model.Reserva;
import com.jvmausa.bookstore.domain.repository.ReservaRepository;

@Service
public class CadastroReservaService {

	@Autowired
	private ReservaRepository reservaRepository;

	public Reserva buscarOuFalhar(Long id) {
		return reservaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(id));
	}

	public Reserva buscarReservaCliente(Cliente cliente) {

		var reservaId = cliente.getReserva().getId();

		Reserva reserva = reservaRepository.findById(reservaId)
				.orElseThrow(() -> new ReservaNaoEncontradaEmClienteException(reservaId));

		return reserva;

	}

}
