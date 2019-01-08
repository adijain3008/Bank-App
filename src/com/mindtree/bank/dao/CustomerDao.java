package com.mindtree.bank.dao;

import java.util.List;
import java.util.Map;

import com.mindtree.bank.entity.Customer;
import com.mindtree.bank.exception.daoException.customerDaoException.CustomerDaoException;

public interface CustomerDao {

	String addCustomer(Customer customer) throws CustomerDaoException;

	Customer getCustomerById(long accountNumber) throws CustomerDaoException;

	List<Customer> getAllCustomers() throws CustomerDaoException;

	String updateCustomer(Customer customer) throws CustomerDaoException;

	String deleteCustomerById(long accountNumber) throws CustomerDaoException;

	Map<String, List<Customer>> getCustomerWithHighestBalance() throws CustomerDaoException;

	double getMaleCustomerPercentage() throws CustomerDaoException;
}
