package com.jvmausa.bookstore.domain.model;

public enum StatusReserva {
	
	PENDENTE,
	ATRASO,
	PAGO;
	
//	PENDENTE("pendente"),
//	ATRASO("atraso", PENDENTE),
//	PAGO("pago", PENDENTE);
//	
//	
//	private String descricao;
//	private List<StatusReserva> statusAnteriores;
//	
//	
//	private StatusReserva(String descricao, StatusReserva... statusAnteriores) {
//		this.descricao = descricao;
//		this.statusAnteriores = Arrays.asList(statusAnteriores);
//	}
//	
//	
//	public String getDescricao() {
//		return this.descricao;
//	}
//	
//		
//	public boolean naoPodeAlterarPara(StatusReserva novoStatus) {
//		return !novoStatus.statusAnteriores.contains(this);
//	}
//	
//	
//	public boolean podeAlterarPara(StatusReserva novoStatus) {
//		return !naoPodeAlterarPara(novoStatus);
//		
//	}
	
}
