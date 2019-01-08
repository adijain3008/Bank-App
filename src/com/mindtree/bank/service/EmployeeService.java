package com.mindtree.bank.service;

import java.util.List;

import com.mindtree.bank.entity.Employee;
import com.mindtree.bank.exception.serviceException.employeeDaoException.EmployeeServiceException;

public interface EmployeeService {

	String addEmployee(Employee employee) throws EmployeeServiceException;

	Employee getEmployeeById(int empId) throws EmployeeServiceException;

	List<Employee> getAllEmployees() throws EmployeeServiceException;

	String updateEmployee(Employee employee) throws EmployeeServiceException;

	String deleteEmployeeById(int empId) throws EmployeeServiceException;

	List<Employee> getEmployeeByDepartment(String department, int bankCode) throws EmployeeServiceException;
}