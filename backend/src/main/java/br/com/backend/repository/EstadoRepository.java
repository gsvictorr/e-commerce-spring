package br.com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
