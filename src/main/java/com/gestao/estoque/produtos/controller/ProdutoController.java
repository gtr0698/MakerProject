package com.gestao.estoque.produtos.controller;

import com.gestao.estoque.produtos.dto.produto.CreateProdutoRequestDto;
import com.gestao.estoque.produtos.dto.produto.ProdutoResponseDto;
import com.gestao.estoque.produtos.dto.produto.UpdateProdutoRequestDto;
import com.gestao.estoque.produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponseDto>adicionar(@Valid @RequestBody CreateProdutoRequestDto produto){
        ProdutoResponseDto produtoSalvo = new ProdutoResponseDto(produtoService.salvar(produto));

        return ResponseEntity.ok(produtoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>>listar(Pageable pageable){
        List<ProdutoResponseDto> produtos = produtoService.listar(pageable).stream()
                .map(ProdutoResponseDto::new).collect(Collectors.toList());

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<ProdutoResponseDto>buscar(@PathVariable Long produtoId){
        ProdutoResponseDto produtoLocalizado = new ProdutoResponseDto(produtoService.buscar(produtoId));

        return ResponseEntity.ok(produtoLocalizado);
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<ProdutoResponseDto>atualizar(@Valid @PathVariable Long produtoId,
                                                       @RequestBody UpdateProdutoRequestDto produto){
        ProdutoResponseDto produtoSalvo = new ProdutoResponseDto(produtoService.atualizar(produtoId,
                produto));

        return ResponseEntity.ok(produtoSalvo);
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<?>remover(@PathVariable Long produtoId){
        produtoService.excluir(produtoId);

        return ResponseEntity.noContent().build();
    }

}
