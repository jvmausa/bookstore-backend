package com.jvmausa.bookstore.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.jvmausa.bookstore.api.controller.ReservaController;
import com.jvmausa.bookstore.api.model.ReservaModel;
import com.jvmausa.bookstore.domain.model.Reserva;

@Component
public class ReservaModelAssembler extends RepresentationModelAssemblerSupport<Reserva, ReservaModel> {

	public ReservaModelAssembler() {
		super(ReservaController.class, ReservaModel.class);
	}

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ReservaModel toModel(Reserva reserva) {
		
		ReservaModel reservaModel = createModelWithId(reserva.getId(), reserva);
		
		modelMapper.map(reserva, reservaModel);
		
		return reservaModel;
	}

	
	
}
