package br.com.backend.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.entity.Pessoa;
import br.com.backend.repository.PessoaRepository;

@Service
public class GerenciamentoService {

    @Autowired
    private PessoaRepository pessoaRep;

    @Autowired
    private EmailService emailService;

    // serviço de recuperação de senha
    public String solicitarCodigo(String email) {

        try {

            Pessoa pessoa = pessoaRep.findByEmail(email);
            pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
            pessoa.setDataEnvioCodigo(new Date());
            pessoaRep.saveAndFlush(pessoa);
            emailService.enviarEmailSimples(pessoa.getEmail(), "Código de recuperação de senha",
                    "Olá, o seu código de recuperação de senha é: " + pessoa.getCodigoRecuperacaoSenha());
            return "Código enviado com sucesso.";
        } catch (Exception ex) {
            return "Código deu falha ao enviar";
        }
    }

    public String alterarSenha(Pessoa pessoa) {

        Pessoa pessoaBanco = pessoaRep.findByEmailAndCodigoRecuperacaoSenha(pessoa.getEmail(),
                pessoa.getCodigoRecuperacaoSenha());
        if (pessoaBanco != null) {
            Date validadeCodigo = new Date(new Date().getTime() - pessoaBanco.getDataEnvioCodigo().getTime());

            // validade do código de 15 minutos calculado em milisegundos
            if (validadeCodigo.getTime() / 1000 < 900) {
                pessoaBanco.setSenha(pessoa.getSenha());
                pessoaBanco.setCodigoRecuperacaoSenha(null);
                pessoaBanco.setDataEnvioCodigo(null);
                pessoaRep.saveAndFlush(pessoaBanco);
                return "Senha alterada com sucesso";
            } else {
                return "Tempo expirado, solicite um novo código de recuperação de senha.";
            }
        } else {
            return "Email ou código não encontrado";
        }
    }

    private String getCodigoRecuperacaoSenha(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date()) + id;
    }

}
