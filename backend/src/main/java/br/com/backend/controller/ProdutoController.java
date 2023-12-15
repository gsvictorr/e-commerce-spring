package br.com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.entity.Produto;
import br.com.backend.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoSer;

    // busca de produto
    @GetMapping("/")
    public List<Produto> buscarTodos() {
        return produtoSer.buscarTodos();
    }

    // adicionar produto
    @PostMapping("/")
    public Produto inserir(@RequestBody Produto produto) {
        return produtoSer.inserir(produto);
    }

    // alterar produto
    @PutMapping("/")
    public Produto alterar(@RequestBody Produto produto) {
        return produtoSer.alterar(produto);

    }

    // deletar produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        produtoSer.excluir(id);
        return ResponseEntity.ok().build();
    }
}
