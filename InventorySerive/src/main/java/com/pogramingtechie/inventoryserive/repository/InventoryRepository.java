package com.pogramingtechie.inventoryserive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pogramingtechie.inventoryserive.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	 List<Inventory> findBySkuCodeIn(List<String> skuCode);

}
