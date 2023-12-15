package br.com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
