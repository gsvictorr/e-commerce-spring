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

import br.com.backend.entity.Pessoa;
import br.com.backend.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaSer;

    // busca de Pessoa
    @GetMapping("/")
    public List<Pessoa> buscarTodos() {
        return pessoaSer.buscarTodos();
    }

    // adicionar Pessoa
    @PostMapping("/")
    public Pessoa inserir(@RequestBody Pessoa pessoa) {
        return pessoaSer.inserir(pessoa);
    }

    // alterar Pessoa
    @PutMapping("/")
    public Pessoa alterar(@RequestBody Pessoa pessoa) {
        return pessoaSer.alterar(pessoa);

    }

    // deletar Pessoa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        pessoaSer.excluir(id);
        return ResponseEntity.ok().build();
    }
}
