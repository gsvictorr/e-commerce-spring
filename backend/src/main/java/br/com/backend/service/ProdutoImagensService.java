package br.com.backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.backend.entity.Produto;
import br.com.backend.entity.ProdutoImagens;
import br.com.backend.repository.ProdutoImagensRepository;
import br.com.backend.repository.ProdutoRepository;

@Service
public class ProdutoImagensService {

    @Autowired
    private ProdutoImagensRepository imagemRep;

    @Autowired
    private ProdutoRepository produtoRep;

    public List<ProdutoImagens> buscarTodos() {
        return imagemRep.findAll();
    }

    public ProdutoImagens inserir(Long idProduto, MultipartFile file) {
        Produto produto = produtoRep.findById(idProduto).get();
        ProdutoImagens imagemNova = new ProdutoImagens();

        // salva a imagem no caminho
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId())
                        + file.getOriginalFilename();
                Path caminho = Paths.get("c:/imagensProduto/" +nomeImagem);
                Files.write(caminho, bytes);
                imagemNova.setNome(nomeImagem);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // salva as infos da imagem no banco

        imagemNova.setProduto(produto);
        imagemNova.setDataCriacao(new Date());
        imagemNova = imagemRep.saveAndFlush(imagemNova);
        return imagemNova;
    }

    public ProdutoImagens alterar(ProdutoImagens imagem) {
        imagem.setDataAtualizacao(new Date());
        return imagemRep.saveAndFlush(imagem);

    }

    public void excluir(Long id) {
        ProdutoImagens imagem = imagemRep.findById(id).get();
        imagemRep.delete(imagem);

    }
}
