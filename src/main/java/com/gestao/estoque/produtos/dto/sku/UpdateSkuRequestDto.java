package com.gestao.estoque.produtos.dto.sku;

import com.gestao.estoque.produtos.model.Produto;
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
public class UpdateSkuRequestDto {

    @NotBlank
    @NotEmpty
    @Size(min = 7)
    private String codigo;

    @NotNull
    @ManyToOne
    private Produto produto;

    public UpdateSkuRequestDto(String codigo, Produto produto) {
        this.codigo = codigo;
        this.produto = produto;
    }
}
