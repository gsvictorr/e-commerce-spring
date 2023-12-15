package br.com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
