package br.com.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.entity.Produto;
import br.com.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRep;

    public List<Produto> buscarTodos() {
        return produtoRep.findAll();
    }

    public Produto buscarPorId(Long id) {
        Produto produto = produtoRep.findById(id).get();
        return produto;
    }

    public Produto inserir(Produto produto) {
        produto.setDataCriacao(new Date());
        Produto produtoNovo = produtoRep.saveAndFlush(produto);
        return produtoNovo;
    }

    public Produto alterar(Produto produto) {
        produto.setDataAtualizacao(new Date());
        return produtoRep.saveAndFlush(produto);

    }

    public void excluir(Long id) {
        Produto produto = produtoRep.findById(id).get();
        produtoRep.delete(produto);

    }
}
