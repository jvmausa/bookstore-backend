package com.jvmausa.bookstore.domain.exception;

public class ReservaNaoEncontradaEmClienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ReservaNaoEncontradaEmClienteException(String mensagem) {
		super(mensagem);
	}

	public ReservaNaoEncontradaEmClienteException(Long id) {
		this(String.format("Não existe reserva para cliente com id %d", id));

	}
}
