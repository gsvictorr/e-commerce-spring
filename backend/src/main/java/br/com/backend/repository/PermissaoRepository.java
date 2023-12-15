package br.com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.entity.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
