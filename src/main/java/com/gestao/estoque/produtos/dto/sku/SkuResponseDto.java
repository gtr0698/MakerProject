package com.gestao.estoque.produtos.dto.sku;

import com.gestao.estoque.produtos.model.Produto;
import com.gestao.estoque.produtos.model.Sku;
import lombok.Getter;

@Getter
public class SkuResponseDto {

    private Long id;
    private String codigo;
    private Produto produto;

    public SkuResponseDto(Sku sku) {
        this.id = sku.getId();
        this.codigo = sku.getCodigo();
        this.produto = sku.getProduto();
    }
}
