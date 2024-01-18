package com.webshop.spring.service;

import org.springframework.stereotype.Service;

import com.webshop.spring.dao.CustomerRepository;
import com.webshop.spring.dto.Purchase;
import com.webshop.spring.dto.PurchaseResponse;

@Service
public class CheckoutServiceImpl implements CheckoutService{

	private CustomerRepository customerRepository;
	

	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public PurchaseResponse placeOrder(Purchase purchase) {
		return null;
	}

}
