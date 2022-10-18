package com.crm.service;

import java.util.List;

import com.crm.model.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(long theId);

	public void save(Customer theCustomer);

	public void deleteById(long theId);
}