package com.metodosave.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //serve para deixar o código mais enxuto (não precisando criar todos aqueles métodos CRUD na Controller)
@Transactional
public class ProdutoService {

	@Autowired //INJETAMOS O REPOSITORY NO SERVICE
	private ProdutoRepository repo;
	
	//MÉTODO SAVE - NESTE CASO USAREMOS O THYMELEAF
	public void save(TableProduto produto) {
		repo.save(produto);
	}
	
	
	
	
}
