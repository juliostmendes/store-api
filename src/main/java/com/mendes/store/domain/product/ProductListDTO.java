package com.mendes.store.domain.product;

public record ProductListDTO (Long id, String name) {
    public ProductListDTO(Product obj){
        this(obj.getId(), obj.getName());
    }
}
