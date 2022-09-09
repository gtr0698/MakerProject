package com.gestao.estoque.produtos.controller;

import com.gestao.estoque.produtos.repository.RequisicaoUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requisicao")
public class RequisicaoUrlController {

    @Autowired
    private RequisicaoUrl requisicaoUrl;

    @GetMapping
    public String requisicaoWeb(){
        String requisicao = requisicaoUrl.retorno();

        return requisicao;
    }


}
