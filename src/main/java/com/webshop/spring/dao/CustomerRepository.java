package com.webshop.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webshop.spring.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
