package com.gestao.estoque.produtos.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "requisicao", url = "http://mockbin.org/bin/fd9103a1-81dc-4a5d-88c3-dd9f8eaf2661")
public interface RequisicaoUrl {

    @GetMapping
    String retorno();
}
