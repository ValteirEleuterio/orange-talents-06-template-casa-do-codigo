package br.com.zupacademy.valteir.casadocodigo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.valteir.casadocodigo.entities.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

}
