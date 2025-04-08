package com.mendes.store.config;

import com.mendes.store.domain.product.Product;
import com.mendes.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("I'm running this now");

        Product p1 = new Product(null, "Computer", "Super bom", 2545.99, 0.0);
        Product p2 = new Product(null, "Texted", "Good", 2545.99, 0.0);
        Product p3 = new Product(null, "Smart phone", "Super poggers", 2545.99, 0.0);

        productRepository.saveAll(Arrays.asList(p1, p2, p3));


    }
}
