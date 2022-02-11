package com.jvmausa.bookstore.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jvmausa.bookstore.domain.model.Reserva;

@Component
public class ReservaInputDisassembler {

	
	@Autowired
	private ModelMapper modelMapper;
	
	public Reserva toDomainObject(ReservaInput reservaInput) {
		return modelMapper.map(reservaInput, Reserva.class);
		
	}
	
	
}
