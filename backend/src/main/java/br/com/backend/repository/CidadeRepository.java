package br.com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.entity.Cidade;


public interface CidadeRepository extends JpaRepository<Cidade, Long>{
    
}
