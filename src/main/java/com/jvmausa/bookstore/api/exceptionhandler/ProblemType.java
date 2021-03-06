package com.jvmausa.bookstore.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensivel"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
	CLIENTE_NAO_POSSUI_RESERVA("/cliente-sem-reserva", "Cliente não possui reserva"),
	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos");

	private String title;
	private String uri;

	ProblemType(String path, String title) {
		this.uri = "https://bookstore.com.br" + path;
		this.title = title;

	}

}
