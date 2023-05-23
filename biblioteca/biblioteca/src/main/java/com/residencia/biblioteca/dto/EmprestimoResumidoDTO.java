package com.residencia.biblioteca.dto;

import java.math.BigDecimal;
import java.util.Date;

public class EmprestimoResumidoDTO {

	private Date dataEmprestimo;
	private Date dataEntrega;
	private BigDecimal valorEmprestimo;
	private LivroResumidoDTO livroResumidoDTO;

	public EmprestimoResumidoDTO() {
		super();

	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(BigDecimal valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public LivroResumidoDTO getLivroResumidoDTO() {
		return livroResumidoDTO;
	}

	public void setLivroResumidoDTO(LivroResumidoDTO livroResumidoDTO) {
		this.livroResumidoDTO = livroResumidoDTO;
	}

}
