package com.jvmausa.bookstore.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.jvmausa.bookstore.api.controller.LivroController;
import com.jvmausa.bookstore.api.model.LivroModel;
import com.jvmausa.bookstore.domain.model.Livro;

@Component
public class LivroModelAssembler extends RepresentationModelAssemblerSupport<Livro, LivroModel>{
	
	public LivroModelAssembler() {
		super(LivroController.class, LivroModel.class);
	}

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public LivroModel toModel(Livro livro) {
		
		LivroModel livroModel = createModelWithId(livro.getId(), livro);
		
		modelMapper.map(livro, livroModel);
		
		return livroModel;
	}

	
	
	
	
}
