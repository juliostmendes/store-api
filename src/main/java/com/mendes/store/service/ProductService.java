package com.mendes.store.service;

import com.mendes.store.domain.product.Product;
import com.mendes.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> listProducts(){
        return repository.findAll();
    }

    public Product getReferenceById(Long id){
        return repository.getReferenceById(id);
    }

    public void deleteProduct(Long id){
        Product obj = repository.getReferenceById(id);
        repository.delete(obj);
    }
}
