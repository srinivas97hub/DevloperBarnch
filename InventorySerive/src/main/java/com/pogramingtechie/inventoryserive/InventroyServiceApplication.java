package com.pogramingtechie.inventoryserive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.pogramingtechie.inventoryserive.model.Inventory;
import com.pogramingtechie.inventoryserive.repository.InventoryRepository;

@SpringBootApplication
@EnableEurekaClient
public class InventroyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventroyServiceApplication.class, args);
	}

	// @Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone 13");
			inventory.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone 13_red");
			inventory1.setQuantity(0);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);

		};
	}

}
