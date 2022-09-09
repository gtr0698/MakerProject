package com.gestao.estoque.produtos.controller;

import com.gestao.estoque.produtos.dto.sku.CreateSkuRequestDto;
import com.gestao.estoque.produtos.dto.sku.SkuResponseDto;
import com.gestao.estoque.produtos.dto.sku.UpdateSkuRequestDto;
import com.gestao.estoque.produtos.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/identificador")
public class SkuController {

    @Autowired
    SkuService skuService;


    @PostMapping
    public ResponseEntity<SkuResponseDto>adicionar(@Valid @RequestBody CreateSkuRequestDto sku){
        SkuResponseDto salvarSku = new SkuResponseDto(skuService.salvar(sku));

        return ResponseEntity.ok(salvarSku);
    }

    @GetMapping
    public ResponseEntity<List<SkuResponseDto>> listar(Pageable pageable){
        List<SkuResponseDto> listaSku = skuService.listar(pageable).stream()
                .map(sku -> new SkuResponseDto(sku)).collect(Collectors.toList());

        return ResponseEntity.ok(listaSku);
    }

    @GetMapping("/{skuId}")
    public ResponseEntity<SkuResponseDto> buscar(@PathVariable Long skuId){
        SkuResponseDto localizaSku = new SkuResponseDto(skuService.buscar(skuId));

        return ResponseEntity.ok(localizaSku);
    }

    @PutMapping("/{skuId}")
    public ResponseEntity<SkuResponseDto>atualizar(@Valid @PathVariable Long skuId,
                                                         @RequestBody UpdateSkuRequestDto sku){
        SkuResponseDto salvarSku = new SkuResponseDto(skuService.atualizar(skuId, sku));

        return ResponseEntity.ok(salvarSku);
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<?> remover(@PathVariable Long skuId){
        skuService.excluir(skuId);

        return ResponseEntity.noContent().build();
    }
}
