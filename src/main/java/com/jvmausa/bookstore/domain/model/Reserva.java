package com.jvmausa.bookstore.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;

	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private OffsetDateTime dataReserva;

	private OffsetDateTime dataDevolucao;

	@Enumerated(EnumType.STRING)
	private StatusReserva statusReserva = StatusReserva.PENDENTE;

	@OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
	private List<ItemReserva> livros = new ArrayList<>();

	private BigDecimal valorTotal;

//	private String codigo;

	// private BigDecimal valorTotal;

//	private void gerarCodigo() {
//		setCodigo(UUID.randomUUID().toString());
//	}
//	
}
