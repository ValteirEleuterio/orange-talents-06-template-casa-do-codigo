package br.com.zupacademy.valteir.casadocodigo.dtos.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.valteir.casadocodigo.config.validators.ExistingValue;
import br.com.zupacademy.valteir.casadocodigo.config.validators.UniqueValue;
import br.com.zupacademy.valteir.casadocodigo.entities.Autor;
import br.com.zupacademy.valteir.casadocodigo.entities.Categoria;
import br.com.zupacademy.valteir.casadocodigo.entities.Livro;

//3
public class LivroRequest {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;
	private String sumario;

	@NotNull
	@DecimalMin("20.00")
	private BigDecimal preco;

	@NotNull
	@Min(100)
	private Integer numeroPaginas;

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	@Future
	@NotNull
	private LocalDate dataPublicacao;

	@NotNull
	@ExistingValue(domainClass = Categoria.class, fieldName = "id")
	private Long categoriaId;

	@NotNull
	@ExistingValue(domainClass = Autor.class, fieldName = "id")
	private Long autorId;

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public Long getAutorId() {
		return autorId;
	}

	public Livro toModel() {
		Categoria categoria = new Categoria();
		categoria.setId(categoriaId);
		Autor autor = new Autor();
		autor.setId(autorId);

		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
	}

}
