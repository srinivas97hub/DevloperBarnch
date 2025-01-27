package com.pogramingtechie.inventoryserive.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pogramingtechie.inventoryserive.dto.InventoryReponce;
import com.pogramingtechie.inventoryserive.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

	private final InventoryRepository inventoryRepository;

	public List<InventoryReponce> getInventory(List<String> skuCode) {
		return inventoryRepository.findBySkuCodeIn(skuCode).stream().map(inventory -> (InventoryReponce.builder()
				.skuCode(inventory.getSkuCode()).f_Instock(inventory.getQuantity() > 0?"Y":"N").build())).toList();
	}
}
