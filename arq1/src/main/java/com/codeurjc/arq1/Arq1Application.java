package com.codeurjc.arq1;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.codeurjc.arq1.domain.ProductUseCaseImpl;
import com.codeurjc.arq1.domain.port.ProductRepository;
import com.codeurjc.arq1.domain.port.ProductUseCase;
import com.codeurjc.arq1.infrastructure.ProductRepositoryAdapter;
import com.codeurjc.arq1.infrastructure.repositories.ProductJpaRepository;

@SpringBootApplication
public class Arq1Application {

	public static void main(String[] args) {
		SpringApplication.run(Arq1Application.class, args);
	}

	@Bean
    public Mapper mapper() {
        return new DozerBeanMapper(Arrays.asList("dozer_mapping.xml"));
    }

    @Bean
    public ProductRepository productRepository(ProductJpaRepository productJpaRepository, Mapper mapper) {
    	return new ProductRepositoryAdapter(productJpaRepository, mapper);
    }
    
    @Bean
    public ProductUseCase productUseCase(ProductRepository productRepository) {
    	return new ProductUseCaseImpl(productRepository);
    }

}
