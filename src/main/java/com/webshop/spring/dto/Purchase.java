package com.webshop.spring.dto;

import java.util.Set;

import com.webshop.spring.model.Address;
import com.webshop.spring.model.Customer;
import com.webshop.spring.model.Order;
import com.webshop.spring.model.OrderItem;

import lombok.Data;

@Data
public class Purchase {
	
	private Customer customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Order order;
	private Set<OrderItem> orderItems;

}
