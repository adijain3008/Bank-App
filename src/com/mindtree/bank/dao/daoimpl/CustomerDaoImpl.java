package com.mindtree.bank.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mindtree.bank.dao.BankDao;
import com.mindtree.bank.dao.CustomerDao;
import com.mindtree.bank.entity.Customer;
import com.mindtree.bank.exception.daoException.bankDaoException.BankDaoException;
import com.mindtree.bank.exception.daoException.customerDaoException.CustomerDaoException;
import com.mindtree.bank.exception.utilException.DbUtilException;
import com.mindtree.bank.util.DbUtil;

public class CustomerDaoImpl implements CustomerDao {

	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement ps = null;
	private BankDao bankDao = new BankDaoImpl();

	@Override
	public String addCustomer(Customer customer) throws CustomerDaoException {
		String query = "insert into customer values(?,?,?,?,?,?,?,?,?,?)";
		String msg = "";
		try {
			conn = DbUtil.getConnection();

			ps = conn.prepareStatement(query);
			ps.setLong(1, customer.getAccountNumber());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getGender());
			ps.setInt(4, customer.getBalance());
			ps.setString(5, customer.getLocation());
			ps.setString(6, customer.getPanID());
			ps.setString(7, customer.getDateOfBirth());
			ps.setInt(8, customer.getAge());
			ps.setLong(9, customer.getPhoneNumber());
			ps.setInt(10, customer.getBank().getBankCode());

			ps.executeUpdate();

			msg = "Customer - " + customer.getName() + " detail added successfully";
			return msg;
		} catch (DbUtilException | SQLException e) {
			throw new CustomerDaoException("Unable to add Customer Details", e);
		}
	}

	@Override
	public Customer getCustomerById(long accountNumber) throws CustomerDaoException {
		String query = "select * from customer where account_number = " + accountNumber;
		Customer customer = null;

		try {
			conn = DbUtil.getConnection();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				customer = new Customer();
				customer.setAccountNumber(rs.getLong(1));
				customer.setName(rs.getString(2));
				customer.setGender(rs.getString(3));
				customer.setBalance(rs.getInt(4));
				customer.setLocation(rs.getString(5));
				customer.setPanID(rs.getString(6));
				customer.setDateOfBirth(rs.getString(7));
				customer.setAge(rs.getInt(8));
				customer.setPhoneNumber(rs.getLong(9));
				customer.setBank(bankDao.getBankById(rs.getInt(10)));
			}
		} catch (DbUtilException | SQLException | BankDaoException e) {
			throw new CustomerDaoException("Unable to get Customer Details", e);
		}

		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() throws CustomerDaoException {
		List<Customer> customers = new ArrayList<>();

		String query = "select * from customer";
		Customer customer = null;
		try {
			conn = DbUtil.getConnection();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				customer = new Customer();
				customer.setAccountNumber(rs.getLong(1));
				customer.setName(rs.getString(2));
				customer.setGender(rs.getString(3));
				customer.setBalance(rs.getInt(4));
				customer.setLocation(rs.getString(5));
				customer.setPanID(rs.getString(6));
				customer.setDateOfBirth(rs.getString(7));
				customer.setAge(rs.getInt(8));
				customer.setPhoneNumber(rs.getLong(9));
				customer.setBank(bankDao.getBankById(rs.getInt(10)));

				customers.add(customer);
			}
		} catch (DbUtilException | SQLException | BankDaoException e) {
			throw new CustomerDaoException("Unable to get Customer Details", e);
		}
		return customers;
	}

	@Override
	public String updateCustomer(Customer customer) throws CustomerDaoException {
		String query = "update customer set customer_name = ? where account_number = ? ";
		String msg = "";
		try {
			conn = DbUtil.getConnection();

			ps = conn.prepareStatement(query);
			ps.setString(1, customer.getName());
			ps.setLong(2, customer.getAccountNumber());

			ps.executeUpdate();

			msg = "Customer - " + customer.getName() + " data updated successfully";
			return msg;
		} catch (DbUtilException | SQLException e) {
			throw new CustomerDaoException("Unable to update Customer Details", e);
		}
	}

	@Override
	public String deleteCustomerById(long accountNumber) throws CustomerDaoException {
		String query = "delete from customer where account_number = " + accountNumber;
		String msg = "";
		try {
			conn = DbUtil.getConnection();
			st = conn.createStatement();
			int row = st.executeUpdate(query);
			msg = (row > 0) ? "Deleted customer successfully" : "This account number doesn't exist";
			return msg;
		} catch (DbUtilException | SQLException e) {
			throw new CustomerDaoException("Unable to delete Customer Details", e);
		}

	}

	@Override
	public Map<String, List<Customer>> getCustomerWithHighestBalance() throws CustomerDaoException {
		Map<String, List<Customer>> highestBalanceCustomerData = new HashMap<>();

		String query = "select bank_code, max(balance) from customer group by bank_code";

		try {
			conn = DbUtil.getConnection();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			List<Customer> customerList = getAllCustomers();

			while (rs.next()) {
				int bankCode = rs.getInt(1);
				double maxBalance = rs.getDouble(2);

				String bankName = customerList.stream().filter(c -> c.getBank().getBankCode() == bankCode)
						.collect(Collectors.toList()).get(0).getBank().getName();
				List<Customer> listCustomers = customerList.stream().filter(c -> c.getBalance() == maxBalance)
						.collect(Collectors.toList());

				highestBalanceCustomerData.put(bankName, listCustomers);
			}
		} catch (DbUtilException | SQLException e) {
			throw new CustomerDaoException("Unable to get Customer Details", e);
		}

		return highestBalanceCustomerData;
	}

	@Override
	public double getMaleCustomerPercentage() throws CustomerDaoException {
		List<Customer> listCustomers = getAllCustomers();

		long numMales = listCustomers.stream().filter(c -> c.getGender().equalsIgnoreCase("male")).count();

		return (double) ((numMales * 100L) / listCustomers.size());
	}
}