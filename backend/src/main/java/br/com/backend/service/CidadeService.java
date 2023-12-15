package br.com.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.entity.Cidade;
import br.com.backend.repository.CidadeRepository;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRep;

    public List<Cidade> buscarTodos() {
        return cidadeRep.findAll();
    }

    public Cidade inserir(Cidade cidade) {
        cidade.setDataCriacao(new Date());
        Cidade cidadeNova = cidadeRep.saveAndFlush(cidade);
        return cidadeNova;
    }

    public Cidade alterar(Cidade cidade) {
        cidade.setDataAtualizacao(new Date());
        return cidadeRep.saveAndFlush(cidade);

    }

    public void excluir(Long id) {
        Cidade cidade = cidadeRep.findById(id).get();
        cidadeRep.delete(cidade);

    }

}
