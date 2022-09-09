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
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Produto(String nome, Integer quantidade, String descricao, String marca, String departamento) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.marca = marca;
        this.departamento = departamento;
    }

    public Produto atualizaProduto(String nome, Integer quantidade, String descricao, String marca,
                                   String departamento) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.marca = marca;
        this.departamento = departamento;

        return this;
    }
}
