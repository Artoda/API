package com.residencia.biblioteca.dto;

import java.util.Date;

import com.residencia.biblioteca.entities.Aluno;

public class SaveAlunoDTO {

	private Integer numeroMatriculaAluno;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private String logradouro;
	private String numeroLogradouro;
	private String complemento;
	private String bairro;
	private String cidade;

	public SaveAlunoDTO() {
		super();

	}
	
	public Aluno toEntity() {
		Aluno aluno = new Aluno();
		
		aluno.setNome(this.nome);
		aluno.setDataNascimento(this.dataNascimento);
		aluno.setCpf(this.cpf);
		aluno.setLogradouro(this.logradouro);
		aluno.setNumeroLogradouro(this.numeroLogradouro);
		aluno.setComplemento(this.complemento);
		aluno.setBairro(this.bairro);
		aluno.setCidade(this.cidade);
		
		return aluno;
	}

	public Integer getNumeroMatriculaAluno() {
		return numeroMatriculaAluno;
	}

	public void setNumeroMatriculaAluno(Integer numeroMatriculaAluno) {
		this.numeroMatriculaAluno = numeroMatriculaAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
