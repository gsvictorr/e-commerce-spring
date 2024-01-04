package br.com.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.entity.Permissao;
import br.com.backend.entity.PermissaoPessoa;
import br.com.backend.entity.Pessoa;
import br.com.backend.repository.PermissaoPessoaRepository;
import br.com.backend.repository.PermissaoRepository;

@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRep;

    @Autowired
    private PermissaoRepository permissaoRep;

    public void vincularPessoaPermissaoCliente(Pessoa pessoa) {
        List<Permissao> listaPermissao = permissaoRep.findByNome("cliente");
        if (listaPermissao.size() > 0) {
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            permissaoPessoaRep.saveAndFlush(permissaoPessoa);
        }

    }

}
