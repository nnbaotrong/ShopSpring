package com.webshop.spring.service;

import java.util.Set;
import java.util.UUID;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Service;

import com.webshop.spring.dao.CustomerRepository;
import com.webshop.spring.dto.Purchase;
import com.webshop.spring.dto.PurchaseResponse;
import com.webshop.spring.model.Customer;
import com.webshop.spring.model.Order;
import com.webshop.spring.model.OrderItem;

import jakarta.transaction.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	private CustomerRepository customerRepository;

	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {

		// retrieve the order info from dto
		// lấy thông tin đơn hàng từ dto
		Order order = purchase.getOrder();

		// generate tracking number
		// tạo số theo dõi
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);

		// populate order with orderItems
		// điền đơn hàng với orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));

		// populate order with billingAddress and shippingAddress
		// điền đơn hàng với địa chỉ thanh toán và địa chỉ vận chuyển
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());

		// populate customer with order
		// điền đơn hàng cho khách hàng
		Customer customer = purchase.getCustomer();
		customer.add(order);

		// save to the database
		// lưu vào cơ sở dữ liệu
		customerRepository.save(customer);

		// return a response
		// trả về một phản hồi

		return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {
		// generate a random UUID number (UUID version-4)
		// For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier

		return UUID.randomUUID().toString();

	}

}
