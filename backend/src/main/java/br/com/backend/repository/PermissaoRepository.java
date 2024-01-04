package br.com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.entity.Permissao;
import java.util.List;


public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

    List<Permissao> findByNome(String nome);


}
