package com.example.springbootmvcexample;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Controller
public class ProductController {
    @NonNull
    private final ProductRepository repository;
    private WebClient client = WebClient.create("http://localhost:7654/products");

    @GetMapping("/products")
    public String getProducts(Model model) {

        model.addAttribute("products", repository.findAll());

        return "products";
    }
}
