package com.mindtree.bank.service.serviceimpl;

import java.util.List;
import java.util.Map;

import com.mindtree.bank.dao.CustomerDao;
import com.mindtree.bank.dao.daoimpl.CustomerDaoImpl;
import com.mindtree.bank.entity.Customer;
import com.mindtree.bank.exception.daoException.customerDaoException.CustomerDaoException;
import com.mindtree.bank.exception.serviceException.customerServiceException.CustomerServiceException;
import com.mindtree.bank.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public String addCustomer(Customer customer) throws CustomerServiceException {
		for (Customer cust : this.getAllCustomers()) {
			if (customer.getAccountNumber() == cust.getAccountNumber()) {
				throw new CustomerServiceException("This Account Number already exists");
			}
		}

		if (customer.getBalance() <= 0) {
			throw new CustomerServiceException("Balance should be greater than 0");
		}
		if (!(customer.getGender().equalsIgnoreCase("male") || customer.getGender().equalsIgnoreCase("female")
				|| customer.getGender().equalsIgnoreCase("other"))) {
			throw new CustomerServiceException("Enter valid gender");
		}
		if (customer.getBank() == null) {
			throw new CustomerServiceException("This bank doesn't exist yet");
		}
		if (customer.getAge() < 16) {
			throw new CustomerServiceException("Age can't be less than 16");
		}

		try {
			return customerDao.addCustomer(customer);
		} catch (CustomerDaoException e) {
			throw new CustomerServiceException(e);
		}
	}

	@Override
	public Customer getCustomerById(long accountNumber) throws CustomerServiceException {
		try {
			return customerDao.getCustomerById(accountNumber);
		} catch (CustomerDaoException e) {
			throw new CustomerServiceException(e);
		}
	}

	@Override
	public List<Customer> getAllCustomers() throws CustomerServiceException {
		try {
			return customerDao.getAllCustomers();
		} catch (CustomerDaoException e) {
			throw new CustomerServiceException(e);
		}
	}

	@Override
	public String updateCustomer(Customer customer) throws CustomerServiceException {
		try {
			return customerDao.updateCustomer(customer);
		} catch (CustomerDaoException e) {
			throw new CustomerServiceException(e);
		}
	}

	@Override
	public String deleteCustomerById(long accountNumber) throws CustomerServiceException {
		try {
			return customerDao.deleteCustomerById(accountNumber);
		} catch (CustomerDaoException e) {
			throw new CustomerServiceException(e);
		}
	}

	@Override
	public Map<String, List<Customer>> getCustomerWithHighestBalance() throws CustomerServiceException {
		try {
			return customerDao.getCustomerWithHighestBalance();
		} catch (CustomerDaoException e) {
			throw new CustomerServiceException(e);
		}
	}

	@Override
	public double getMaleCustomerPercentage() throws CustomerServiceException {
		try {
			return customerDao.getMaleCustomerPercentage();
		} catch (CustomerDaoException e) {
			throw new CustomerServiceException(e);
		}
	}

}
