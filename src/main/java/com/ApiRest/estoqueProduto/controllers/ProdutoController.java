package com.ApiRest.estoqueProduto.controllers;

import com.ApiRest.estoqueProduto.entities.Produto;
import com.ApiRest.estoqueProduto.respositories.ProdutoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRespository repository;

    @GetMapping
    public List<Produto> findAll(){
        List<Produto> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public Produto findById(@PathVariable Long id){
        Produto result = repository.findById(id).get();
        return result;
    }

    @PostMapping()
    public Produto insert(@RequestBody Produto produto){
        Produto result = repository.save(produto);
        return result;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Produto> upadate (@PathVariable Long id, @RequestBody Produto produto) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        produto.setId(id);
        produto = repository.save(produto);

        return ResponseEntity.ok(produto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }




    }

