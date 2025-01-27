package com.pogramingtechie.orderservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pogramingtechie.orderservice.dto.OrderLineItemsDto;
import com.pogramingtechie.orderservice.dto.OrderRequest;
import com.pogramingtechie.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String PlaceOrder(@RequestBody OrderRequest orderRequest) {
		orderService.placeOrder(orderRequest);
		return "Order Placed sucessfully";
	}

	public List<OrderLineItemsDto> getAllOrderLineItems() {
		return orderService.getAllorderLineItems();
	}
}
