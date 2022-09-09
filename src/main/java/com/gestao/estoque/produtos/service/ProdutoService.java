package com.gestao.estoque.produtos.service;

import com.gestao.estoque.produtos.Exception.RegraException;
import com.gestao.estoque.produtos.dto.produto.CreateProdutoRequestDto;
import com.gestao.estoque.produtos.dto.produto.UpdateProdutoRequestDto;
import com.gestao.estoque.produtos.model.Produto;
import com.gestao.estoque.produtos.model.Sku;
import com.gestao.estoque.produtos.repository.ProdutoRepository;
import com.gestao.estoque.produtos.repository.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(CreateProdutoRequestDto produtoDto){

        Produto produtoNovo = produtoDto.convertToModel();

        return produtoRepository.save(produtoNovo);
    }

    public Page<Produto> listar(Pageable pageable){
        return produtoRepository.findAll(pageable);
    }

    public Produto buscar(Long produtoId){
        Produto produto = verificaExistencia(produtoId);

        return produto;
    }

    public Produto atualizar(Long produtoId, UpdateProdutoRequestDto produtoRequest){
        Produto produto = verificaExistencia(produtoId);
        Produto produtoAtualizado = produto.atualizaProduto(produtoRequest.getNome(),
        produtoRequest.getQuantidade(), produtoRequest.getDescricao(), produtoRequest.getMarca(),
        produtoRequest.getDepartamento());

        return produtoRepository.save(produtoAtualizado);
    }

    public void excluir(Long produtoId){

        verificaExistencia(produtoId);

        produtoRepository.deleteById(produtoId);
    }

    public Produto verificaExistencia(Long produtoId){
        Optional<Produto> produto = produtoRepository.findById(produtoId);

        if(produto.isEmpty()){

            throw new RegraException("Produto não encontrado");
        }

        return produto.get();
    }

}
