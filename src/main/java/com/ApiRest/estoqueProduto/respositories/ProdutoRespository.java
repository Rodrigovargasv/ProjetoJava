package com.ApiRest.estoqueProduto.respositories;

import com.ApiRest.estoqueProduto.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRespository extends JpaRepository<Produto, Long> {

}


