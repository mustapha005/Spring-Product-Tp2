package org.example.springmvc2;

import org.example.springmvc2.entities.Product;
import org.example.springmvc2.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class,SecurityFilterAutoConfiguration.class})

@SpringBootApplication
public class SpringMvc2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvc2Application.class, args);
    }

    @Bean
    public CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(8000)
                    .quantity(17)
                    .build());
            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(2000)
                    .quantity(7)
                    .build());
            productRepository.save(Product.builder()
                    .name("Smartphone")
                    .price(10000)
                    .quantity(33)
                    .build());
            productRepository.findAll().forEach(p -> {
                System.out.println(p.toString());
            });
        };
    }
}