package io.github.bortoletoeric.produtosapi.controler;

import io.github.bortoletoeric.produtosapi.model.Produto;
import io.github.bortoletoeric.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoControler {

    private final ProdutoRepository produtoRepository;

    public ProdutoControler(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto recebido: " + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("{id}")
    public Produto buscarPorId(@PathVariable("id") String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletarPorId(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Produto atualizarProdutoPorId(@PathVariable("id") String id,
                                         @RequestBody Produto produto) {
        System.out.println("Produto recebido: " + produto);
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public List<Produto> buscarPorNome(@RequestParam("nome") String nome) {
        return produtoRepository.findByNome(nome);
    }
}
