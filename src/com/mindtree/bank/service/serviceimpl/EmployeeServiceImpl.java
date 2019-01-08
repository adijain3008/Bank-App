package com.mindtree.bank.service.serviceimpl;

import java.util.List;

import com.mindtree.bank.dao.EmployeeDao;
import com.mindtree.bank.dao.daoimpl.EmployeeDaoImpl;
import com.mindtree.bank.entity.Employee;
import com.mindtree.bank.exception.daoException.employeeDaoException.EmployeeDaoException;
import com.mindtree.bank.exception.serviceException.employeeDaoException.EmployeeServiceException;
import com.mindtree.bank.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public String addEmployee(Employee employee) throws EmployeeServiceException {
		for (Employee emp : this.getAllEmployees()) {
			if (employee.getEmpid() == emp.getEmpid()) {
				throw new EmployeeServiceException("This Employee ID already exists");
			}
		}

		if (employee.getSalary() <= 0) {
			throw new EmployeeServiceException("Salary should be greater than 0");
		}
		if (!(employee.getGender().equalsIgnoreCase("male") || employee.getGender().equalsIgnoreCase("female")
				|| employee.getGender().equalsIgnoreCase("other"))) {
			throw new EmployeeServiceException("Enter valid gender");
		}
		if (employee.getBank() == null) {
			throw new EmployeeServiceException("This bank doesn't exist yet");
		}

		try {
			return employeeDao.addEmployee(employee);
		} catch (EmployeeDaoException e) {
			throw new EmployeeServiceException(e);
		}
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeServiceException {
		try {
			return employeeDao.getEmployeeById(empId);
		} catch (EmployeeDaoException e) {
			throw new EmployeeServiceException(e);
		}
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeServiceException {
		try {
			return employeeDao.getAllEmployees();
		} catch (EmployeeDaoException e) {
			throw new EmployeeServiceException(e);
		}
	}

	@Override
	public String updateEmployee(Employee employee) throws EmployeeServiceException {
		try {
			return employeeDao.updateEmployee(employee);
		} catch (EmployeeDaoException e) {
			throw new EmployeeServiceException(e);
		}
	}

	@Override
	public String deleteEmployeeById(int empId) throws EmployeeServiceException {
		try {
			return employeeDao.deleteEmployeeById(empId);
		} catch (EmployeeDaoException e) {
			throw new EmployeeServiceException(e);
		}
	}

	@Override
	public List<Employee> getEmployeeByDepartment(String department, int bankCode) throws EmployeeServiceException {
		try {
			return employeeDao.getEmployeeByDepartment(department, bankCode);
		} catch (EmployeeDaoException e) {
			throw new EmployeeServiceException(e);
		}
	}
}
