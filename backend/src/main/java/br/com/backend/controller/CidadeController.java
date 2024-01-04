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

import br.com.backend.entity.Cidade;
import br.com.backend.service.CidadeService;

@RestController
@RequestMapping("/api/cidade")

public class CidadeController {

    @Autowired
    private CidadeService cidadeSer;

    // busca de cidades
    @GetMapping("/")
    public List<Cidade> buscarTodos() {
        return cidadeSer.buscarTodos();
    }

    // adicionar cidades
    @PostMapping("/")
    public Cidade inserir(@RequestBody Cidade cidade) {
        return cidadeSer.inserir(cidade);
    }

    // alterar cidades
    @PutMapping("/")
    public Cidade alterar(@RequestBody Cidade cidade) {
        return cidadeSer.alterar(cidade);

    }

    // deletar cidades
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        cidadeSer.excluir(id);
        return ResponseEntity.ok().build();
    }
}
