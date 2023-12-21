package br.com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.dto.ClienteRequestDTO;
import br.com.backend.entity.Pessoa;
import br.com.backend.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteSer;

    // Inserir cliente
    @PostMapping("/")
    public Pessoa inserir(@RequestBody ClienteRequestDTO cliente) {
        return clienteSer.registrar(cliente);
    }
}
