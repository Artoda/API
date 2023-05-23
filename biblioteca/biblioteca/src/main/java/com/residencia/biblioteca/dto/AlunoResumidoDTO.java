package com.residencia.biblioteca.dto;

import java.util.List;

public class AlunoResumidoDTO {

	private String nome;
	private String cpf;
	private List<EmprestimoResumidoDTO> listaEmprestimoResDTO;

	public AlunoResumidoDTO() {
		super();

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<EmprestimoResumidoDTO> getListaEmprestimoResDTO() {
		return listaEmprestimoResDTO;
	}

	public void setListaEmprestimoResDTO(List<EmprestimoResumidoDTO> listaEmprestimoResDTO) {
		this.listaEmprestimoResDTO = listaEmprestimoResDTO;
	}

}
