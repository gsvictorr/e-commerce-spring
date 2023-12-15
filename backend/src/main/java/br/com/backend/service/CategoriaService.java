package br.com.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.entity.Categoria;
import br.com.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRep;

    public List<Categoria> buscarTodos() {
        return categoriaRep.findAll();
    }

    public Categoria inserir(Categoria categoria) {
        categoria.setDataCriacao(new Date());
        Categoria categoriaNova = categoriaRep.saveAndFlush(categoria);
        return categoriaNova;
    }

    public Categoria alterar(Categoria categoria) {
        categoria.setDataAtualizacao(new Date());
        return categoriaRep.saveAndFlush(categoria);

    }

    public void excluir(Long id) {
        Categoria categoria = categoriaRep.findById(id).get();
        categoriaRep.delete(categoria);

    }
}
