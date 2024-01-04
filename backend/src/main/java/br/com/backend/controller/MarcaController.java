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

import br.com.backend.entity.Marca;
import br.com.backend.service.MarcaService;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {
    @Autowired
    private MarcaService marcaSer;

    // busca de Marca
    @GetMapping("/")
    public List<Marca> buscarTodos() {
        return marcaSer.buscarTodos();
    }

    // adicionar Marca
    @PostMapping("/")
    public Marca inserir(@RequestBody Marca marca) {
        return marcaSer.inserir(marca);
    }

    // alterar Marca
    @PutMapping("/")
    public Marca alterar(@RequestBody Marca marca) {
        return marcaSer.alterar(marca);

    }

    // deletar Marca
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        marcaSer.excluir(id);
        return ResponseEntity.ok().build();
    }
}
