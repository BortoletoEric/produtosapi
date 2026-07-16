package io.github.bortoletoeric.produtosapi.repository;

import io.github.bortoletoeric.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    
}
