package br.com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.entity.Pessoa;
import br.com.backend.service.GerenciamentoService;

@RestController
@RequestMapping("/api/pessoa-gerenciamento")
public class GerenciamentoController {

    @Autowired
    private GerenciamentoService gerenciamentoService;

    @PostMapping("/codigo-senha")
    public String recuperarCodigo(@RequestBody Pessoa pessoa) {
        return gerenciamentoService.solicitarCodigo(pessoa.getEmail());
    }

    @PostMapping("/alterar-senha")
    public String alterarSenha(@RequestBody Pessoa pessoa) {
        return gerenciamentoService.alterarSenha(pessoa);
    }

}
