package com.jvmausa.bookstore.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvmausa.bookstore.domain.exception.EntidadeNaoEncontradaException;
import com.jvmausa.bookstore.domain.model.Livro;
import com.jvmausa.bookstore.domain.repository.LivroRepository;

@Service
public class CadastroLivroService {

	@Autowired
	private LivroRepository livroRepository;

	public Livro buscarOuFalhar(Long id) {
		return livroRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(id));

	}

	@Transactional
	public Livro salvar(Livro livro) {

		return livroRepository.save(livro);

	}

	/*
	 * TODO excluir
	 */
}
