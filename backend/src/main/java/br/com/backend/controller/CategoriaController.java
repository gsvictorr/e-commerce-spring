package br.com.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.backend.entity.Categoria;
import br.com.backend.service.CategoriaService;

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

@RestController
@RequestMapping("/api/categoria")

public class CategoriaController {

    @Autowired
    private CategoriaService categoriaSer;

    // busca de Categoria
    @GetMapping("/")
    public List<Categoria> buscarTodos() {
        return categoriaSer.buscarTodos();
    }

    // adicionar Categoria
    @PostMapping("/")
    public Categoria inserir(@RequestBody Categoria categoria) {
        return categoriaSer.inserir(categoria);
    }

    // alterar Categoria
    @PutMapping("/")
    public Categoria alterar(@RequestBody Categoria categoria) {
        return categoriaSer.alterar(categoria);

    }

    // deletar Categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        categoriaSer.excluir(id);
        return ResponseEntity.ok().build();
    }

}
