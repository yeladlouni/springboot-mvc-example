package com.example.springbootmvcexample;

import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;

@AllArgsConstructor
@Configuration
public class ProductRetriever {
    private final ProductRepository repository;

    @Bean
    Consumer<List<Product>> retrieveProduct() {
        return pList -> {
            repository.deleteAll();
            repository.saveAll(pList);
            repository.findAll().forEach(System.out::println);
        };
    }
}
