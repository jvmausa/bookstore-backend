package com.jvmausa.bookstore.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.domain.AbstractAggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Reserva extends AbstractAggregateRoot<Reserva> {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private OffsetDateTime dataReserva;

	private OffsetDateTime dataDevolucaoPrev;

	private OffsetDateTime dataDevolucao;

	@Enumerated(EnumType.STRING)
	private StatusReserva statusReserva;

	private BigDecimal valorFinal;

	private Boolean atraso;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_livro")
	private Livro livro;

	public boolean verificaAtraso() {

		if (this.dataDevolucao.isAfter(this.dataDevolucaoPrev)) {
			return this.atraso = true;
		} else {
			return this.atraso = false;
		}

	}

	OffsetDateTime addDays(OffsetDateTime dataReserva) {
		return dataReserva.plusDays(7);

	}

}
