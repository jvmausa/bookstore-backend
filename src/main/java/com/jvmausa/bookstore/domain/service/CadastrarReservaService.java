package com.jvmausa.bookstore.domain.service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvmausa.bookstore.domain.model.Cliente;
import com.jvmausa.bookstore.domain.model.Livro;
import com.jvmausa.bookstore.domain.model.Reserva;
import com.jvmausa.bookstore.domain.model.StatusLivro;
import com.jvmausa.bookstore.domain.model.StatusReserva;
import com.jvmausa.bookstore.domain.repository.ClienteRepository;
import com.jvmausa.bookstore.domain.repository.ReservaRepository;

@Service
public class CadastrarReservaService {

	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	public void emitirNovaReserva(Reserva novaReserva, Livro livroReserva, Cliente clienteReserva) {

		novaReserva.setDataReserva(OffsetDateTime.parse("2022-02-01T09:37:01-03:00"));
		novaReserva.setDataDevolucaoPrev(addDays(novaReserva));
		novaReserva.setStatusReserva(StatusReserva.PENDENTE);
		novaReserva.setLivro(livroReserva);

		novaReserva.getLivro().setStatus(StatusLivro.EMPRESTADO);

		novaReserva.setDataDevolucao(OffsetDateTime.now());
		Boolean atraso = novaReserva.verificaAtraso();

		if (atraso) {
			novaReserva.setValorFinal(calculoMulta(novaReserva));

		}

		reservaRepository.save(novaReserva);
		clienteReserva.setReserva(novaReserva);

		clienteRepository.save(clienteReserva);
	}

	public OffsetDateTime addDays(Reserva reserva) {
		OffsetDateTime dataReserva = reserva.getDataReserva();
		return dataReserva.plusDays(7);

	}

	public BigDecimal calculoMulta(Reserva reserva) {

		BigDecimal valorFinal = BigDecimal.ZERO;
		BigDecimal valorComJuros = BigDecimal.ZERO;

		// tá pegando a diferença de dias
		int devolucao = reserva.getDataDevolucao().getDayOfMonth();
		int previsao = reserva.getDataDevolucaoPrev().getDayOfMonth();
		int diferenca = devolucao - previsao;

		BigDecimal preco = reserva.getLivro().getPreco();

		if (diferenca != 0 && diferenca <= 3) {
			BigDecimal multa = BigDecimal.valueOf(0.03);
			BigDecimal juros = BigDecimal.valueOf(0.002);

			preco = preco.multiply(multa.add(BigDecimal.ONE));

			for (int dia = 1; dia <= diferenca; dia++) {
				valorComJuros = preco.multiply(juros.add(BigDecimal.ONE).pow(dia));

			}
			valorFinal = valorComJuros;

		}

		if (diferenca > 3 && diferenca <= 5) {
			BigDecimal multa = BigDecimal.valueOf(0.05);
			BigDecimal juros = BigDecimal.valueOf(0.004);

			preco = preco.multiply(multa.add(BigDecimal.ONE));

			for (int dia = 1; dia <= diferenca; dia++) {
				valorComJuros = preco.multiply(juros.add(BigDecimal.ONE).pow(dia));

			}
			valorFinal = valorComJuros;

		}

		if (diferenca > 5) {
			BigDecimal multa = BigDecimal.valueOf(0.07);
			BigDecimal juros = BigDecimal.valueOf(0.006);

			preco = preco.multiply(multa.add(BigDecimal.ONE));

			for (int dia = 1; dia <= diferenca; dia++) {
				valorComJuros = preco.multiply(juros.add(BigDecimal.ONE).pow(dia));

			}
			valorFinal = valorComJuros;

		}

		return valorFinal;
	}

}
