package br.com.zupacademy.valteir.casadocodigo.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.valteir.casadocodigo.entities.Livro;

//1
public interface LivroRepository extends CrudRepository<Livro, Long>{

}
