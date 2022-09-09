package com.gestao.estoque.produtos.repository;

import com.gestao.estoque.produtos.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkuRepository extends JpaRepository <Sku, Long> {

}
