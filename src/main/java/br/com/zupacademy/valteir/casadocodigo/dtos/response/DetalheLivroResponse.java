package br.com.zupacademy.valteir.casadocodigo.dtos.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.zupacademy.valteir.casadocodigo.entities.Livro;

@JsonInclude(Include.NON_NULL)
public class DetalheLivroResponse {

	private String titulo;
	private String resumo;
	private DetalheAutorResponse autor;
	private String sumario;
	private String isbn;
	private BigDecimal preco;
	private Integer numeroPaginas;

	public DetalheLivroResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.autor = new DetalheAutorResponse(livro.getAutor());
		this.sumario = livro.getSumario();
		this.isbn = livro.getIsbn();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public DetalheAutorResponse getAutor() {
		return autor;
	}

	public String getSumario() {
		return sumario;
	}

	public String getIsbn() {
		return isbn;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

}
