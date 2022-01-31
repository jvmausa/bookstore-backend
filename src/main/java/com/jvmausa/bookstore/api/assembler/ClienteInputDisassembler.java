package com.jvmausa.bookstore.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jvmausa.bookstore.api.model.input.ClienteInput;
import com.jvmausa.bookstore.domain.model.Cliente;

@Component
public class ClienteInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Cliente toDomainObject(ClienteInput clienteInput) {
		return modelMapper.map(clienteInput, Cliente.class);

	}

}
