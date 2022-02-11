
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

import com.jvmausa.bookstore.api.assembler.LivroInputDisassembler;
import com.jvmausa.bookstore.api.assembler.LivroModelAssembler;
import com.jvmausa.bookstore.api.model.LivroModel;
import com.jvmausa.bookstore.api.model.input.LivroInput;
import com.jvmausa.bookstore.domain.exception.DadosInvalidosException;
import com.jvmausa.bookstore.domain.model.Cliente;
import com.jvmausa.bookstore.domain.model.Livro;
import com.jvmausa.bookstore.domain.model.Reserva;
import com.jvmausa.bookstore.domain.repository.LivroRepository;
import com.jvmausa.bookstore.domain.service.CadastrarReservaService;
import com.jvmausa.bookstore.domain.service.CadastroClienteService;
import com.jvmausa.bookstore.domain.service.CadastroLivroService;

@RestController
@RequestMapping(path = "/books")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CadastroLivroService cadastroLivro;

	@Autowired
	private CadastrarReservaService cadastrarReservaService;

	@Autowired
	private CadastroClienteService cadastroCliente;

	@Autowired
	private LivroModelAssembler livroModelAssembler;

	@Autowired
	private LivroInputDisassembler livroInputDisassembler;

	@GetMapping
	public CollectionModel<LivroModel> listar() {

		return livroModelAssembler.toCollectionModel(livroRepository.findAll());

	}

	@GetMapping("/{id}")
	public LivroModel buscar(@PathVariable Long id) {

		Livro livro = cadastroLivro.buscarOuFalhar(id);

		LivroModel livroModel = livroModelAssembler.toModel(livro);

		return livroModel;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	LivroModel adicionar(@RequestBody @Valid LivroInput livroInput) {

		Livro livro = livroInputDisassembler.toDomainObject(livroInput);

		livro = cadastroLivro.salvar(livro);

		try {
			LivroModel livroModel = livroModelAssembler.toModel(livro);

			return livroModel;
		} catch (RuntimeException e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	@PostMapping("/{livroId}/reserve")
	@ResponseStatus(HttpStatus.CREATED)
	void reservarLivro(@Valid @PathVariable Long livroId) {

		try {
			Livro livro = cadastroLivro.buscarOuFalhar(livroId);

			Cliente cliente = cadastroCliente.buscarOuFalhar(1L);

			cadastrarReservaService.emitirNovaReserva(new Reserva(), livro, cliente);

		} catch (RuntimeException e) {
			throw new DadosInvalidosException(e.getMessage());
		}

	}

}
