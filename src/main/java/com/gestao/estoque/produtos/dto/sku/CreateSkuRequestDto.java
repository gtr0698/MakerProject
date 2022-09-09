package com.gestao.estoque.produtos.dto.sku;

import com.gestao.estoque.produtos.dto.produto.ProdutoRequestDto;
import com.gestao.estoque.produtos.model.Produto;
import com.gestao.estoque.produtos.model.Sku;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreateSkuRequestDto {

    @NotBlank
    @NotEmpty
    @Size(min = 7)
    private String codigo;

    @NotNull
    private ProdutoRequestDto produto;

    public CreateSkuRequestDto(String codigo, ProdutoRequestDto produto) {
        this.codigo = codigo;
        this.produto = produto;
    }

    public Sku convertToModel(Produto produto){
        return new Sku(codigo, produto);
    }
}
