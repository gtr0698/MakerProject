package com.gestao.estoque.produtos.service;

import com.gestao.estoque.produtos.Exception.RegraException;
import com.gestao.estoque.produtos.dto.sku.CreateSkuRequestDto;
import com.gestao.estoque.produtos.dto.sku.UpdateSkuRequestDto;
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
public class SkuService {

    @Autowired
    private SkuRepository skuRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Sku salvar(CreateSkuRequestDto skuDto){
        Produto produto = produtoRepository.findById(skuDto.getProduto().getId()).orElseThrow(() ->

            new RegraException("Produto com o id = " + skuDto.getProduto().getId(), "não encontrado"));

        Sku adicionarSku = skuDto.convertToModel(produto);

        return skuRepository.save(adicionarSku);
    }

    public Page<Sku> listar(Pageable pageable){
        return skuRepository.findAll(pageable);
    }

    public Sku buscar(Long skuId){
        Sku buscarSku = verificaExistencia(skuId);

        return buscarSku;
    }

    public Sku atualizar(Long skuId, UpdateSkuRequestDto skuRequest){
        Sku sku = verificaExistencia(skuId);
        Sku skuAtualizado = sku.atualizarSku(skuRequest.getCodigo(), skuRequest.getProduto());

        return skuRepository.save(skuAtualizado);
    }

    public void excluir(Long skuId){

        verificaExistencia(skuId);

        skuRepository.deleteById(skuId);
    }

    public Sku verificaExistencia(Long skuId){
        Optional<Sku> sku = skuRepository.findById(skuId);

        if(sku.isEmpty()){

            throw new RegraException("Codigo de barras não encontrada");
        }

        return sku.get();
    }

}
