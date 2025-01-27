package com.pogramingtechie.productserive.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pogramingtechie.productserive.dto.ProductRequest;
import com.pogramingtechie.productserive.dto.ProductResponce;
import com.pogramingtechie.productserive.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveProduct(@RequestBody List<ProductRequest> productRequest) {
		productService.saveProdut(productRequest);
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProductResponce> getProduct() {
		return productService.getProdut();
	}

}
