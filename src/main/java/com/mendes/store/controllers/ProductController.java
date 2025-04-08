package com.mendes.store.controllers;

import com.mendes.store.domain.product.Product;
import com.mendes.store.domain.product.ProductDetailDTO;
import com.mendes.store.domain.product.ProductListDTO;
import com.mendes.store.service.ProductService;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductListDTO>> getProducts(){
        var list = service.listProducts().stream().map(ProductListDTO::new).toList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDetailDTO> getProductInfo(@PathVariable Long id){
        Product obj = service.getReferenceById(id);
        return ResponseEntity.ok().body(new ProductDetailDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){
        service.deleteProduct(id);;
        return ResponseEntity.noContent().build();
    }
}
