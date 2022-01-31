package com.jvmausa.bookstore.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jvmausa.bookstore.api.model.input.LivroInput;
import com.jvmausa.bookstore.domain.model.Livro;

@Component
public class LivroInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Livro toDomainObject(LivroInput livroInput) {
		return modelMapper.map(livroInput, Livro.class);

	}

}
