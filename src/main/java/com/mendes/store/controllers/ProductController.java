package com.mendes.store.controllers;

import com.mendes.store.domain.product.*;
import com.mendes.store.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping
    @Transactional
    public ResponseEntity createProduct(@RequestBody ProductSaveDTO obj, UriComponentsBuilder uriBuilder){
        Product product = new Product(obj);
        service.saveProduct(product);

        var uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable Long id){
        service.deleteProduct(id);;
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity updateProduct(@RequestBody ProductUpdateDTO obj){
        Product product = service.getReferenceById(obj.id());
        product.updateInfo(obj);

        return ResponseEntity.ok().body(new ProductDetailDTO(product));
    }
}
