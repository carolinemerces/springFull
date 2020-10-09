package com.metodosave.global;

import org.springframework.data.jpa.repository.JpaRepository;

//importa a classe repository na service (injeta) e a service na controller

public interface ProdutoRepository extends JpaRepository<TableProduto, Long>{

}
