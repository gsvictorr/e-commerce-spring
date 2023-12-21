package br.com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.entity.Pessoa;

public interface ClienteRepository extends JpaRepository<Pessoa, Long> {

}
