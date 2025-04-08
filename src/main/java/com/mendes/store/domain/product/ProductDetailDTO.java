package com.mendes.store.domain.product;

public record ProductDetailDTO(Long id, String name, String description, Double price, Double rating) {
    public ProductDetailDTO(Product obj){
        this(obj.getId(), obj.getName(), obj.getDescription(), obj.getPrice(), obj.getRating());
    }
}
