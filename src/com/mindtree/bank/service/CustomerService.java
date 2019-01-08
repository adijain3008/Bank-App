package com.mindtree.bank.service;

import java.util.List;
import java.util.Map;

import com.mindtree.bank.entity.Customer;
import com.mindtree.bank.exception.serviceException.customerServiceException.CustomerServiceException;

public interface CustomerService {

	String addCustomer(Customer customer) throws CustomerServiceException;

	Customer getCustomerById(long accountNumber) throws CustomerServiceException;

	List<Customer> getAllCustomers() throws CustomerServiceException;

	String updateCustomer(Customer customer) throws CustomerServiceException;

	String deleteCustomerById(long accountNumber) throws CustomerServiceException;

	Map<String, List<Customer>> getCustomerWithHighestBalance() throws CustomerServiceException;

	double getMaleCustomerPercentage() throws CustomerServiceException;
}
