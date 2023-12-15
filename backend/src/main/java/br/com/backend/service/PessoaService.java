package br.com.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.entity.Pessoa;
import br.com.backend.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRep;

    public List<Pessoa> buscarTodos() {
        return pessoaRep.findAll();
    }

    public Pessoa inserir(Pessoa pessoa) {
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNova = pessoaRep.saveAndFlush(pessoa);
        return pessoaNova;
    }

    public Pessoa alterar(Pessoa pessoa) {
        pessoa.setDataAtualizacao(new Date());
        return pessoaRep.saveAndFlush(pessoa);

    }

    public void excluir(Long id) {
        Pessoa pessoa = pessoaRep.findById(id).get();
        pessoaRep.delete(pessoa);

    }
}
