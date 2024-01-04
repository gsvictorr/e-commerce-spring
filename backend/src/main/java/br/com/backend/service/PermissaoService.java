package br.com.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.entity.Permissao;
import br.com.backend.repository.PermissaoRepository;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRep;

    public List<Permissao> buscarTodos() {
        return permissaoRep.findAll();
    }

    public Permissao inserir(Permissao permissao) {
        permissao.setDataCriacao(new Date());
        Permissao permissaoNova = permissaoRep.saveAndFlush(permissao);
        return permissaoNova;
    }

    public Permissao alterar(Permissao permissao) {
        permissao.setDataAtualizacao(new Date());
        return permissaoRep.saveAndFlush(permissao);

    }

    public void excluir(Long id) {
        Permissao permissao = permissaoRep.findById(id).get();
        permissaoRep.delete(permissao);

    }
}
