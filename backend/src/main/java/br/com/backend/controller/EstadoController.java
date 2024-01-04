package br.com.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.backend.entity.Estado;
import br.com.backend.service.EstadoService;

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
@RequestMapping("/api/estado")

public class EstadoController {

    @Autowired
    private EstadoService estadoSer;

    // busca de estados
    @GetMapping("/")
    public List<Estado> buscarTodos() {
        return estadoSer.buscarTodos();
    }

    // adicionar estado
    @PostMapping("/")
    public Estado inserir(@RequestBody Estado estado) {
        return estadoSer.inserir(estado);
    }

    // alterar estado
    @PutMapping("/")
    public Estado alterar(@RequestBody Estado estado) {
        return estadoSer.alterar(estado);

    }

    // deletar estado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        estadoSer.excluir(id);
        return ResponseEntity.ok().build();
    }

}
