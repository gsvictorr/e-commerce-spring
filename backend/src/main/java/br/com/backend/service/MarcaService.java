package br.com.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.entity.Marca;
import br.com.backend.repository.MarcaRepository;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRep;

    public List<Marca> buscarTodos() {
        return marcaRep.findAll();
    }

    public Marca inserir(Marca marca) {
        marca.setDataCriacao(new Date());
        Marca marcaNova = marcaRep.saveAndFlush(marca);
        return marcaNova;
    }

    public Marca alterar(Marca marca) {
        marca.setDataAtualizacao(new Date());
        return marcaRep.saveAndFlush(marca);

    }

    public void excluir(Long id) {
        Marca marca = marcaRep.findById(id).get();
        marcaRep.delete(marca);

    }
}
