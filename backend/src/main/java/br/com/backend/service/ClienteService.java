package br.com.backend.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.dto.ClienteRequestDTO;
import br.com.backend.entity.Pessoa;
import br.com.backend.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository pessoaRep;


    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    // serviço de registrar cliente
    public Pessoa registrar(ClienteRequestDTO cliente) {
        Pessoa novaPessoa = new ClienteRequestDTO().converter(cliente);
        novaPessoa.setDataCriacao(new Date());
        Pessoa pessoaNova = pessoaRep.saveAndFlush(novaPessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNova);
        return pessoaNova;
    }
}
