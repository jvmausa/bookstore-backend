package com.jvmausa.bookstore.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.jvmausa.bookstore.api.controller.ClienteController;
import com.jvmausa.bookstore.api.model.ClienteModel;
import com.jvmausa.bookstore.domain.model.Cliente;

@Component
public class ClienteModelAssembler extends RepresentationModelAssemblerSupport<Cliente, ClienteModel> {

	public ClienteModelAssembler() {
		super(ClienteController.class, ClienteModel.class);
	}

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ClienteModel toModel(Cliente cliente) {

		ClienteModel clienteModel = createModelWithId(cliente.getId(), cliente);

		modelMapper.map(cliente, clienteModel);

		return clienteModel;

	}

}
