package com.gestao.estoque.produtos.dto.produto;

import com.gestao.estoque.produtos.model.Produto;
import com.gestao.estoque.produtos.model.Sku;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProdutoResponseDto {

    private Long id;
    private String nome;
    private Integer quantidade;
    private String descricao;
    private String marca;
    private String departamento;

    public ProdutoResponseDto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.quantidade = produto.getQuantidade();
        this.descricao = produto.getDescricao();
        this.marca = produto.getMarca();
        this.departamento = produto.getDepartamento();
    }
}
