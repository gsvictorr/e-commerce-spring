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

    @Autowired
    private EmailService emailService;

    // serviço de registrar cliente
    public Pessoa registrar(ClienteRequestDTO cliente) {
        Pessoa novaPessoa = new ClienteRequestDTO().converter(cliente);
        novaPessoa.setDataCriacao(new Date());
        Pessoa pessoaNova = pessoaRep.saveAndFlush(novaPessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNova);
        emailService.enviarEmailSimples(pessoaNova.getEmail(), "Cadastro na loja SpringMall",
                "O seu registro na SpringMall foi realizado com sucesso. Em breve receberá a senha de acesso por email!");
        return pessoaNova;
    }
}
