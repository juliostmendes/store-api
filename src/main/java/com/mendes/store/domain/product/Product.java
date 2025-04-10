package com.mendes.store.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "products")
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Double rating = 0D;

    public Product(ProductSaveDTO obj){
        this.name = obj.name();
        this.description = obj.description();
        this.price = obj.price();
        this.rating = 0.0;
    }

    public void updateInfo(ProductUpdateDTO obj){
        if(obj.name() != null){
            this.name = obj.name();
        }
        if(obj.description() != null){
            this.description = obj.description();
        }
        if(obj.price() != null){
            this.price = obj.price();
        }
    }
}
