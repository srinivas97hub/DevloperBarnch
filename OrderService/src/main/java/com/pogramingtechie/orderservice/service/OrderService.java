package com.pogramingtechie.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.pogramingtechie.orderservice.dto.InventoryReponce;
import com.pogramingtechie.orderservice.dto.OrderLineItemsDto;
import com.pogramingtechie.orderservice.dto.OrderRequest;
import com.pogramingtechie.orderservice.model.Order;
import com.pogramingtechie.orderservice.model.OrderLineItems;
import com.pogramingtechie.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;

	@Autowired
	private WebClient.Builder webClientBuilder;

	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList().stream().map(this::MaptoDto)
				.toList();
		order.setOrderLineItems(orderLineItems);

		List<String> skuCodes = orderLineItems.stream().map(OrderLineItems::getSkuCode).toList();

		for (String s : skuCodes) {
			System.out.println(s);
		}

		InventoryReponce[] inventories = webClientBuilder.build().get()
				.uri("http://inventoyservice/api/inventory",
						UriBuilder -> UriBuilder.queryParam("skucode", skuCodes).build())
				.retrieve().bodyToMono(InventoryReponce[].class).block();

		boolean stock = false;
		for (InventoryReponce res : inventories) {
			if (res.getF_Instock().equalsIgnoreCase("Y")) {
				stock = true;
			}
		}

		if (stock) {
			orderRepository.save(order);
		} else {
			throw new IllegalArgumentException("Product not in stock, Please try after sometime");
		}

	}

	private OrderLineItems MaptoDto(OrderLineItemsDto orderRequest) {
		return OrderLineItems.builder().price(orderRequest.getPrice()).quantity(orderRequest.getQuantity())
				.skuCode(orderRequest.getSkuCode()).build();
	}

	public List<OrderLineItemsDto> getAllorderLineItems() {
		// TODO Auto-generated method stub
		return null;
	}
}
