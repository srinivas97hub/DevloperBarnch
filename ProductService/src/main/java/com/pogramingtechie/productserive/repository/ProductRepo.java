package com.pogramingtechie.productserive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pogramingtechie.productserive.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
