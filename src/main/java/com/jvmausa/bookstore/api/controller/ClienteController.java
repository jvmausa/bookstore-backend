package com.jvmausa.bookstore.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jvmausa.bookstore.api.assembler.ClienteInputDisassembler;
import com.jvmausa.bookstore.api.assembler.ClienteModelAssembler;
import com.jvmausa.bookstore.api.model.ClienteModel;
import com.jvmausa.bookstore.api.model.input.ClienteInput;
import com.jvmausa.bookstore.domain.exception.DadosInvalidosException;
import com.jvmausa.bookstore.domain.model.Cliente;
import com.jvmausa.bookstore.domain.repository.ClienteRepository;
import com.jvmausa.bookstore.domain.service.CadastroClienteService;

@RestController
@RequestMapping(path = "/client")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteModelAssembler clienteModelAssembler;

	@Autowired
	private CadastroClienteService cadastroCliente;

	@Autowired
	private ClienteInputDisassembler clienteInputDisassembler;
	
	@GetMapping
	public CollectionModel<ClienteModel> listar() {
		return clienteModelAssembler.toCollectionModel(clienteRepository.findAll());

	}

	@GetMapping(path = "/{id}")
	public ClienteModel buscar(@PathVariable Long id) {
		Cliente cliente = cadastroCliente.buscarOuFalhar(id);
		ClienteModel clienteModel = clienteModelAssembler.toModel(cliente);
		return clienteModel;

	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	ClienteModel adicionar(@RequestBody @Valid ClienteInput clienteInput) {

		Cliente cliente = clienteInputDisassembler.toDomainObject(clienteInput);
		
		cliente = cadastroCliente.salvar(cliente);

		try {
			ClienteModel clienteModel = clienteModelAssembler.toModel(cliente);

			return clienteModel;
		} catch (RuntimeException e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

}
