package com.jvmausa.bookstore.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public EntidadeNaoEncontradaException(Long id) {
		this(String.format("Não existe entidade com esse id %d", id));
	}

}
