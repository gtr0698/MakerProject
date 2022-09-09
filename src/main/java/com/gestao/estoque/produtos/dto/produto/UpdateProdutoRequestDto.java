package com.gestao.estoque.produtos.dto.produto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UpdateProdutoRequestDto {

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

    public UpdateProdutoRequestDto(String nome, Integer quantidade, String descricao,
                                   String marca, String departamento) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.marca = marca;
        this.departamento = departamento;
    }
}
