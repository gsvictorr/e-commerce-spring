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

import br.com.backend.entity.Permissao;
import br.com.backend.service.PermissaoService;

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoSer;

    // busca de Permissao
    @GetMapping("/")
    public List<Permissao> buscarTodos() {
        return permissaoSer.buscarTodos();
    }

    // adicionar Permissao
    @PostMapping("/")
    public Permissao inserir(@RequestBody Permissao permissao) {
        return permissaoSer.inserir(permissao);
    }

    // alterar Permissao
    @PutMapping("/")
    public Permissao alterar(@RequestBody Permissao permissao) {
        return permissaoSer.alterar(permissao);

    }

    // deletar Permissao
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        permissaoSer.excluir(id);
        return ResponseEntity.ok().build();
    }
}
