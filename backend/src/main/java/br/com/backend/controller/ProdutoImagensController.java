package br.com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.backend.entity.ProdutoImagens;
import br.com.backend.service.ProdutoImagensService;

@RestController
@RequestMapping("/api/produtoImagens")
public class ProdutoImagensController {

    @Autowired
    private ProdutoImagensService produtoImgSer;

    // busca de produto
    @GetMapping("/")
    public List<ProdutoImagens> buscarTodos() {
        return produtoImgSer.buscarTodos();
    }

    // adicionar produto
    @PostMapping("/")
    public ProdutoImagens inserir(@RequestParam("idProduto") Long idProduto, @RequestParam("file") MultipartFile file) {
        return produtoImgSer.inserir(idProduto, file);
    }

    // alterar produto
    @PutMapping("/")
    public ProdutoImagens alterar(@RequestBody ProdutoImagens produtoImg) {
        return produtoImgSer.alterar(produtoImg);

    }

    // deletar produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        produtoImgSer.excluir(id);
        return ResponseEntity.ok().build();
    }

}
