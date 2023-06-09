package com.residencia.biblioteca.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "editora")
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoeditora")
	private Integer codigoEditora;

	@Column(name = "nome")
	private String nome;

	@Column(name = "imagem_nome")
	private String imageNome;

	@Column(name = "imagem_filename")
	private String imagemFilename;

	@Column(name = "imagem_url")
	private String imagemUrl;
	
	@OneToMany(mappedBy = "editora")
	private List<Livro> livros;

	public Integer getCodigoEditora() {
		return codigoEditora;
	}

	public void setCodigoEditora(Integer codigoEditora) {
		this.codigoEditora = codigoEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImageNome() {
		return imageNome;
	}

	public void setImageNome(String imageNome) {
		this.imageNome = imageNome;
	}

	public String getImagemFilename() {
		return imagemFilename;
	}

	public void setImagemFilename(String imagemFilename) {
		this.imagemFilename = imagemFilename;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	

}