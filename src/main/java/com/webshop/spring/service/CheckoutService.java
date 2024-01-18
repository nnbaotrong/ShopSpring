package com.webshop.spring.service;

import com.webshop.spring.dto.Purchase;
import com.webshop.spring.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);

}
