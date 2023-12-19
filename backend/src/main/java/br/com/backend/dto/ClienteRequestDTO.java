package br.com.backend.dto;

import org.springframework.beans.BeanUtils;

import br.com.backend.entity.Cidade;
import br.com.backend.entity.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequestDTO {

    private String nome;
    private String cpf;
    private String email;
    private String endereço;
    private String cep;
    private Cidade cidade;

    // converte o objeto clienteDTO em um objeto pessoa
    public Pessoa converter(ClienteRequestDTO clienteDTO) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(clienteDTO, pessoa);
        return pessoa;
    }
}
