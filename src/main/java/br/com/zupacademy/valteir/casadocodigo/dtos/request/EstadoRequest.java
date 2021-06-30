package br.com.zupacademy.valteir.casadocodigo.dtos.request;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zupacademy.valteir.casadocodigo.config.validators.ExistingId;
import br.com.zupacademy.valteir.casadocodigo.entities.Estado;
import br.com.zupacademy.valteir.casadocodigo.entities.Pais;

public class EstadoRequest {
	
	@NotBlank
	//@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	@NotNull
	@ExistingId(domainClass = Pais.class, fieldName = "id")
	private Long paisId;
	
	public EstadoRequest(String nome, Long paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}
	
	public Estado toModel(EntityManager em) {
		Pais pais = em.find(Pais.class, paisId);
		
		validaEstadoNoPais(em, pais);
		
		return new Estado(nome, pais) ;	
	}
	
	private void validaEstadoNoPais(EntityManager em, Pais pais) {
		String jpql = "select e from Estado e where e.nome = :pNome and e.pais.id = :pPaisId";
		Query query = em.createQuery(jpql);
		query.setParameter("pNome", nome);
		query.setParameter("pPaisId", paisId);
		
		List<Estado> resultado = query.getResultList();
		
		Assert.state(resultado.isEmpty(), "O estado "+ nome + " já esta cadastro no pais " + pais.getNome());
	}
}
