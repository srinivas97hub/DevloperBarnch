package com.pogramingtechie.productserive.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pogramingtechie.productserive.dto.ProductRequest;
import com.pogramingtechie.productserive.dto.ProductResponce;
import com.pogramingtechie.productserive.model.Product;
import com.pogramingtechie.productserive.repository.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepo productRepo;

	public void saveProdut(List<ProductRequest> productRequest) {
		List<Product> products = productRequest.stream().map(this:: maptoproduct).toList();
		productRepo.saveAll(products);
	}

	public Product maptoproduct(ProductRequest productRequest) {
		return Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();
	}

	public List<ProductResponce> getProdut() {
		return productRepo.findAll().stream().map(product ->(
				ProductResponce.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build()))
				.toList();

	}
}
