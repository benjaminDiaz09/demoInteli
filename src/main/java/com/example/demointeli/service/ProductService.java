package com.example.demointeli.service;

import com.example.demointeli.model.Product;
import com.example.demointeli.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repo;

    public  ProductService(ProductRepository repo){
        this.repo = repo;
    }

        public List<Product> findAll(){
            return repo.findAll();
        }

        public Optional<Product> findById(Long id){
        return repo.findById(id);
    }

    public Product save(Product product){
        return repo.save(product);
    }

    public Optional<Product> uptade(Long id, Product newProduct){
        Optional<Product> optional = repo.findById(id);
        Product productBd=optional.get();
        productBd.setName(newProduct.getName());
        productBd.setPrice(newProduct.getPrice());
        productBd.setStock(newProduct.getStock());
        return Optional.of(save(productBd));
    }

    public boolean delete(Long id){
        if(!repo.existsById(id)){
            return false;
        }
        repo.deleteById(id);
        return true;
    }


}



