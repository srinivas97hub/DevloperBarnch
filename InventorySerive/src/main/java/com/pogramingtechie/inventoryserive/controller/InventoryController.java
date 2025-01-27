package com.pogramingtechie.inventoryserive.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pogramingtechie.inventoryserive.dto.InventoryReponce;
import com.pogramingtechie.inventoryserive.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/inventory")
@RestController
public class InventoryController {

	private final InventoryService inventoryService;

	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<InventoryReponce> getInventory(@RequestParam List<String> skucode) {
		System.out.println("---------skucode-----" + skucode.size());
		return inventoryService.getInventory(skucode);
	}
}
