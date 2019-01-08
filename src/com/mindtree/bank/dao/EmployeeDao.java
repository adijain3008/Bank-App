package com.mindtree.bank.dao;

import java.util.List;

import com.mindtree.bank.entity.Employee;
import com.mindtree.bank.exception.daoException.employeeDaoException.EmployeeDaoException;

public interface EmployeeDao {

	String addEmployee(Employee employee) throws EmployeeDaoException;

	Employee getEmployeeById(int empId) throws EmployeeDaoException;

	List<Employee> getAllEmployees() throws EmployeeDaoException;

	String updateEmployee(Employee employee) throws EmployeeDaoException;

	String deleteEmployeeById(int empId) throws EmployeeDaoException;

	List<Employee> getEmployeeByDepartment(String department, int bankCode) throws EmployeeDaoException;
}
