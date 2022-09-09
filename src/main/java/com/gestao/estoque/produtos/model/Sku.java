package com.gestao.estoque.produtos.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@NoArgsConstructor
public class Sku{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    private String codigo;

    @NotNull
    @ManyToOne
    private Produto produto;

    public Sku(String codigo, Produto produto) {
        this.codigo = codigo;
        this.produto = produto;
    }

    public Sku atualizarSku(String codigo, Produto produto) {
        this.codigo = codigo;
        this.produto = produto;

        return this;
    }

}
