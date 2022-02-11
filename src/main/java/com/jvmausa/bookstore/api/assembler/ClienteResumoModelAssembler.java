package com.jvmausa.bookstore.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.jvmausa.bookstore.api.controller.ClienteController;
import com.jvmausa.bookstore.api.model.ClienteResumoModel;
import com.jvmausa.bookstore.domain.model.Cliente;

@Component
public class ClienteResumoModelAssembler extends RepresentationModelAssemblerSupport<Cliente, ClienteResumoModel>{

	public ClienteResumoModelAssembler() {
		super(ClienteController.class, ClienteResumoModel.class);
		
	}
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public ClienteResumoModel toModel(Cliente cliente) {
		
		ClienteResumoModel clienteResumoModel = createModelWithId(cliente.getId(), cliente);
		
		modelMapper.map(cliente, clienteResumoModel);
		
		
		return clienteResumoModel;
	}

	
	
	
}
