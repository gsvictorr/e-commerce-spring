package br.com.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.entity.Estado;
import br.com.backend.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRep;

    public List<Estado> buscarTodos() {
        return estadoRep.findAll();
    }

    public Estado inserir(Estado estado) {
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRep.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterar(Estado estado) {
        estado.setDataAtualizacao(new Date());
        return estadoRep.saveAndFlush(estado);

    }

    public void excluir(Long id) {
        Estado estado = estadoRep.findById(id).get();
        estadoRep.delete(estado);

    }
}
