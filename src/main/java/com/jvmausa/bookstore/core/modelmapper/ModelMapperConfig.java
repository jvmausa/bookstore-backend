package com.jvmausa.bookstore.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jvmausa.bookstore.api.assembler.ItemReservaInput;
import com.jvmausa.bookstore.domain.model.ItemReserva;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();

		
		modelMapper.createTypeMap(ItemReservaInput.class, ItemReserva.class)
			.addMappings(mapper -> mapper.skip(ItemReserva::setId));
		
		return modelMapper;
	}
}