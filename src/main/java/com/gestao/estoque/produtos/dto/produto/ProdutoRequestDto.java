package com.gestao.estoque.produtos.dto.produto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProdutoRequestDto {

    private Long id;

    public ProdutoRequestDto(Long id) {
        this.id = id;
    }
}
