package com.gestao.estoque.produtos.dto.produto;

import com.gestao.estoque.produtos.model.Produto;
import com.gestao.estoque.produtos.model.Sku;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreateProdutoRequestDto {

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nome;

    @NotNull
    private Integer quantidade;

    private String descricao;

    @NotBlank
    @NotEmpty
    private String marca;

    @NotBlank
    @NotEmpty
    private String departamento;

    public CreateProdutoRequestDto(String nome, Integer quantidade, String descricao, String marca,
                                   String departamento) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.marca = marca;
        this.departamento = departamento;
    }

    public Produto convertToModel(){
        return new Produto(nome, quantidade, descricao, marca, departamento);
    }
}
