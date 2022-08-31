package com.andreamaccan.backportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackPortfolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackPortfolioApplication.class, args);
    }

    // Enable CORS at global level for al clasess and methods
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://portfolio-frontend-32644.web.app", "https://portfolio-frontend-32644.firebaseapp.com")
                        // .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }
}
