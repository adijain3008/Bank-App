package com.mindtree.bank.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mindtree.bank.dao.BankDao;
import com.mindtree.bank.dao.EmployeeDao;
import com.mindtree.bank.entity.Employee;
import com.mindtree.bank.exception.daoException.bankDaoException.BankDaoException;
import com.mindtree.bank.exception.daoException.employeeDaoException.EmployeeDaoException;
import com.mindtree.bank.exception.utilException.DbUtilException;
import com.mindtree.bank.util.DbUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement ps = null;
	private BankDao bankDao = new BankDaoImpl();

	@Override
	public String addEmployee(Employee employee) throws EmployeeDaoException {
		String query = "insert into employee values(?,?,?,?,?,?,?,?)";
		String msg = "";
		try {
			conn = DbUtil.getConnection();

			ps = conn.prepareStatement(query);
			ps.setInt(1, employee.getEmpid());
			ps.setString(2, employee.getName());
			ps.setDouble(3, employee.getSalary());
			ps.setString(4, employee.getDepartment());
			ps.setString(5, employee.getDesignation());
			ps.setString(6, employee.getGender());
			ps.setString(7, employee.getDateOfJoining());
			ps.setInt(8, employee.getBank().getBankCode());

			ps.executeUpdate();

			msg = "Employee - " + employee.getName() + " detail added successfully";
			return msg;
		} catch (DbUtilException | SQLException e) {
			throw new EmployeeDaoException("Unable to add Employee Details", e);
		}
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeDaoException {
		String query = "select * from employee where emp_id = " + empId;
		Employee employee = null;

		try {
			conn = DbUtil.getConnection();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				employee = new Employee();
				employee.setEmpid(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setDepartment(rs.getString(4));
				employee.setDesignation(rs.getString(5));
				employee.setGender(rs.getString(6));
				employee.setDateOfJoining(rs.getString(7));
				employee.setBank(bankDao.getBankById(rs.getInt(8)));
			}
		} catch (DbUtilException | SQLException | BankDaoException e) {
			throw new EmployeeDaoException("Unable to get Employee Details", e);
		}

		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeDaoException {
		List<Employee> employees = new ArrayList<>();

		String query = "select * from employee";
		Employee employee = null;
		try {
			conn = DbUtil.getConnection();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				employee = new Employee();
				employee.setEmpid(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setDepartment(rs.getString(4));
				employee.setDesignation(rs.getString(5));
				employee.setGender(rs.getString(6));
				employee.setDateOfJoining(rs.getString(7));
				employee.setBank(bankDao.getBankById(rs.getInt(8)));

				employees.add(employee);
			}
		} catch (DbUtilException | SQLException | BankDaoException e) {
			throw new EmployeeDaoException("Unable to get Employee Details", e);
		}
		return employees;
	}

	@Override
	public String updateEmployee(Employee employee) throws EmployeeDaoException {
		String query = "update employee set employee_name = ? where emp_id = ? ";
		String msg = "";
		try {
			conn = DbUtil.getConnection();

			ps = conn.prepareStatement(query);
			ps.setString(1, employee.getName());
			ps.setInt(2, employee.getEmpid());

			ps.executeUpdate();

			msg = "Employee - " + employee.getName() + " data updated successfully";
			return msg;
		} catch (DbUtilException | SQLException e) {
			throw new EmployeeDaoException("Unable to update Employee Details", e);
		}
	}

	@Override
	public String deleteEmployeeById(int empId) throws EmployeeDaoException {
		String query = "delete from employee where emp_id = " + empId;
		String msg = "";
		try {
			conn = DbUtil.getConnection();
			st = conn.createStatement();
			int row = st.executeUpdate(query);
			msg = (row > 0) ? "Deleted Employee successfully" : "This Employee ID doesn't exist";
			return msg;
		} catch (DbUtilException | SQLException e) {
			throw new EmployeeDaoException("Unable to delete Employee Details", e);
		}
	}

	@Override
	public List<Employee> getEmployeeByDepartment(String department, int bankCode) throws EmployeeDaoException {
		return getAllEmployees().stream()
				.filter(e -> (e.getDepartment().equalsIgnoreCase(department) && e.getBank().getBankCode() == bankCode))
				.collect(Collectors.toList());
	}
}
