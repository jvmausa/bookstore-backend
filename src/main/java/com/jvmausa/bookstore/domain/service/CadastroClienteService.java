package com.jvmausa.bookstore.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvmausa.bookstore.domain.exception.EntidadeNaoEncontradaException;
import com.jvmausa.bookstore.domain.model.Cliente;
import com.jvmausa.bookstore.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente buscarOuFalhar(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(id));

	}

	@Transactional
	public Cliente salvar(Cliente cliente) {

		return clienteRepository.save(cliente);

	}

}
