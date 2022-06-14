package com.netcracker;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Homework6", version = "1.0", description = "The bookshop's web application"))
public class BookShopStarter {
    public static void main(String[] args) {
        SpringApplication.run(BookShopStarter.class, args);
    }
}