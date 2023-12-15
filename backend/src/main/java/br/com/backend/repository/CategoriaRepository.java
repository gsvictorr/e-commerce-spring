package br.com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
