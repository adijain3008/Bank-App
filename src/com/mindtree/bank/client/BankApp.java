package com.mindtree.bank.client;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.mindtree.bank.entity.Bank;
import com.mindtree.bank.entity.Customer;
import com.mindtree.bank.entity.Employee;
import com.mindtree.bank.exception.BankAppException;
import com.mindtree.bank.service.BankService;
import com.mindtree.bank.service.CustomerService;
import com.mindtree.bank.service.EmployeeService;
import com.mindtree.bank.service.serviceimpl.BankServiceImpl;
import com.mindtree.bank.service.serviceimpl.CustomerServiceImpl;
import com.mindtree.bank.service.serviceimpl.EmployeeServiceImpl;
import com.mindtree.bank.util.KeyBoardUtil;

public class BankApp {

	private static BankService bankService = new BankServiceImpl();
	private static CustomerService customerService = new CustomerServiceImpl();
	private static EmployeeService employeeService = new EmployeeServiceImpl();

	public static void main(String[] args) throws IOException {
		int choice = 0, option = 0;
		String msg = "";

		System.out.println("**********************************************************************************");
		System.out.println("*************************************Bank App*************************************");
		System.out.println("**********************************************************************************");

		do {
			System.out.println("Perform Operations on: \n 1. Bank \t\t 2. Customer \t\t 3. Employee \t\t 4. Exit");
			while (true) {
				try {
					choice = KeyBoardUtil.getInt();
					if (!(choice == 1 || choice == 2 || choice == 3 || choice == 4)) {
						throw new BankAppException("Enter valid index value!!!");
					}
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage() + "\n" + e.getCause());
				}
			}

			switch (choice) {
			case 1:
				int bankCode = 0;
				Bank bank = null;
				do {
					System.out.println(
							"Perform \n 1. Add a Bank \n 2. Get Bank Details by Bank Code \n 3. Get All Bank Details \n"
									+ " 4. Update Bank Details \n 5. Delete a Bank \n 6. Go back to Previous Menu");
					while (true) {
						try {
							option = KeyBoardUtil.getInt();
							if (!(option == 1 || option == 2 || option == 3 || option == 4 || option == 5
									|| option == 6)) {
								throw new BankAppException("Enter valid index value!!!");
							}
							break;
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
					}

					switch (option) {
					case 1:
						bank = new Bank();

						System.out.print("Enter Bank Code: ");
						bank.setBankCode(KeyBoardUtil.getInt());

						System.out.print("Enter Bank Name: ");
						bank.setName(KeyBoardUtil.getString());

						System.out.print("Enter IFSC Code: ");
						bank.setIfsc(KeyBoardUtil.getString());

						System.out.print("Enter Bank Branch: ");
						bank.setBranch(KeyBoardUtil.getString());

						try {
							msg = bankService.addBank(bank);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}

						System.out.println(msg);
						break;
					case 2:
						System.out.print("Enter Bank Code: ");
						bankCode = KeyBoardUtil.getInt();

						try {
							bank = bankService.getBankById(bankCode);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}

						if (bank != null) {
							System.out.println(bank);
						} else {
							System.out.println("No such Bank exists");
						}
						break;
					case 3:
						List<Bank> banks = null;
						try {
							banks = bankService.getAllBanks();
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
						banks.forEach(System.out::println);
						break;
					case 4:
						System.out.print("Enter Bank code: ");
						bankCode = KeyBoardUtil.getInt();

						try {
							bank = bankService.getBankById(bankCode);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}

						if (bank != null) {
							System.out.print("Enter Bank Updated Name: ");
							bank.setName(KeyBoardUtil.getString());

							try {
								msg = bankService.updateBank(bank);
							} catch (Exception e) {
								System.out.println(e.getMessage() + "\n" + e.getCause());
							}
							System.out.println(msg);
						} else {
							System.out.println("NO such Bank Exists");
						}
						break;
					case 5:
						System.out.print("Enter Bank Code: ");
						bankCode = KeyBoardUtil.getInt();

						try {
							msg = bankService.deleteBankById(bankCode);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
						System.out.println(msg);
						break;
					case 6:
						System.out.println(
								"******************************Going to Previous Menu******************************");
						break;
					}
				} while (option != 6);
				break;

			case 2:
				long accountNumber = 0L;
				Customer customer = null;
				do {
					System.out.println(
							"Perform \n 1. Add a Customer \n 2. Get Customer Details by Account Number \n 3. Get All Customer Details \n"
									+ " 4. Update Customer Details \n 5. Delete a Customer \n 6. Get Highest Balance Customers \n"
									+ " 7. Get Percentage of Male Customers \n 8. Go back to Previous Menu");
					while (true) {
						try {
							option = KeyBoardUtil.getInt();
							if (!(option == 1 || option == 2 || option == 3 || option == 4 || option == 5 || option == 6
									|| option == 7 || option == 8)) {
								throw new BankAppException("Enter valid index value!!!");
							}
							break;
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
					}

					switch (option) {
					case 1:
						customer = new Customer();

						System.out.print("Enter Customer Account Number: ");
						customer.setAccountNumber(KeyBoardUtil.getLong());

						System.out.print("Enter Customer Name: ");
						customer.setName(KeyBoardUtil.getString());

						System.out.print("Enter Customer Gender: ");
						customer.setGender(KeyBoardUtil.getString());

						System.out.print("Enter Customer Balance: ");
						customer.setBalance(KeyBoardUtil.getInt());

						System.out.print("Enter Custmer Location: ");
						customer.setLocation(KeyBoardUtil.getString());

						System.out.print("Enter Customer PAN ID: ");
						customer.setPanID(KeyBoardUtil.getString());

						System.out.print("Enter Date of Birth: ");
						customer.setDateOfBirth(KeyBoardUtil.getString());

						System.out.print("Enter Age: ");
						customer.setAge(KeyBoardUtil.getInt());

						System.out.print("Enter Phone Number: ");
						customer.setPhoneNumber(KeyBoardUtil.getLong());

						System.out.print("Enter Bank Code: ");
						try {
							customer.setBank(bankService.getBankById(KeyBoardUtil.getInt()));
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}

						try {
							msg = customerService.addCustomer(customer);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
						System.out.println(msg);
						break;
					case 2:
						System.out.print("Enter Customer Account Number: ");
						accountNumber = KeyBoardUtil.getLong();

						try {
							customer = customerService.getCustomerById(accountNumber);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
						System.out.println(customer);
						break;
					case 3:
						List<Customer> customers = null;
						try {
							customers = customerService.getAllCustomers();
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
						customers.forEach(System.out::println);
						break;
					case 4:
						System.out.print("Enter Customer Account Number: ");
						accountNumber = KeyBoardUtil.getLong();

						try {
							customer = customerService.getCustomerById(accountNumber);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}

						if (customer != null) {
							System.out.print("Enter Customer Updated Name: ");
							customer.setName(KeyBoardUtil.getString());

							try {
								msg = customerService.updateCustomer(customer);
							} catch (Exception e) {
								System.out.println(e.getMessage() + "\n" + e.getCause());
							}
							System.out.println(msg);
						} else {
							System.out.println("NO such Customer Exists");
						}
						break;
					case 5:
						System.out.print("Enter Customer Account Number: ");
						accountNumber = KeyBoardUtil.getLong();

						try {
							msg = customerService.deleteCustomerById(accountNumber);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
						System.out.println(msg);
						break;
					case 6:
						Map<String, List<Customer>> highestBalacneCustomers = null;
						try {
							highestBalacneCustomers = customerService.getCustomerWithHighestBalance();
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
						for (String bankName : highestBalacneCustomers.keySet()) {
							System.out.println(bankName);
							highestBalacneCustomers.get(bankName).forEach(System.out::println);
						}
						break;
					case 7:
						double malePercentage = 0;
						try {
							malePercentage = customerService.getMaleCustomerPercentage();
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
						System.out.println("Percentage of Male Customers is: " + malePercentage);
						break;
					case 8:
						System.out.println(
								"******************************Going to Previous Menu******************************");
						break;
					}
				} while (option != 8);
				break;

			case 3:
				String department = "";
				int empId = 0;
				Employee employee = null;
				do {
					System.out.println(
							"Perform \n 1. Add a Employee \n 2. Get Employee Details by Employee ID \n 3. Get All Employee Details \n"
									+ " 4. Update Employee Details \n 5. Delete a Employee \n"
									+ " 6. Get Employees By Department \n 7. Go back to Previous Menu");
					while (true) {
						try {
							option = KeyBoardUtil.getInt();
							if (!(option == 1 || option == 2 || option == 3 || option == 4 || option == 5 || option == 6
									|| option == 7)) {
								throw new BankAppException("Enter valid index value!!!");
							}
							break;
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
					}

					switch (option) {
					case 1:
						employee = new Employee();

						System.out.print("Enter Employee ID: ");
						employee.setEmpid(KeyBoardUtil.getInt());

						System.out.print("Enter Employee Name: ");
						employee.setName(KeyBoardUtil.getString());

						System.out.print("Enter Employee Salary: ");
						employee.setSalary(KeyBoardUtil.getDouble());

						System.out.print("Enter Employee Department: ");
						employee.setDepartment(KeyBoardUtil.getString());

						System.out.print("Enter Employee Designation: ");
						employee.setDesignation(KeyBoardUtil.getString());

						System.out.print("Enter Employee Gender: ");
						employee.setGender(KeyBoardUtil.getString());

						System.out.print("Enter Employee Date of Joining: ");
						employee.setDateOfJoining(KeyBoardUtil.getString());

						System.out.print("Enter Employee Bank Code: ");
						try {
							employee.setBank(bankService.getBankById(KeyBoardUtil.getInt()));
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}

						try {
							msg = employeeService.addEmployee(employee);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
						System.out.println(msg);
						break;
					case 2:
						System.out.print("Enter Employee ID: ");
						empId = KeyBoardUtil.getInt();

						try {
							employee = employeeService.getEmployeeById(empId);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
						System.out.println(employee);
						break;
					case 3:
						List<Employee> employees = null;
						try {
							employees = employeeService.getAllEmployees();
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
						employees.forEach(System.out::println);
						break;
					case 4:
						System.out.print("Enter Employee ID: ");
						empId = KeyBoardUtil.getInt();

						try {
							employee = employeeService.getEmployeeById(empId);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}

						if (employee != null) {
							System.out.print("Enter Employee Updated Name: ");
							employee.setName(KeyBoardUtil.getString());

							try {
								msg = employeeService.updateEmployee(employee);
							} catch (Exception e) {
								System.out.println(e.getMessage() + "\n" + e.getCause());
							}
							System.out.println(msg);
						} else {
							System.out.println("NO such Employee Exists");
						}
						break;
					case 5:
						System.out.print("Enter Employee ID: ");
						empId = KeyBoardUtil.getInt();

						try {
							msg = employeeService.deleteEmployeeById(empId);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
						System.out.println(msg);
						break;
					case 6:
						System.out.print("Enter Employee Department: ");
						department = KeyBoardUtil.getString();

						System.out.print("Enter Employee Bank Code: ");
						bankCode = KeyBoardUtil.getInt();

						List<Employee> empList = null;
						try {
							empList = employeeService.getEmployeeByDepartment(department, bankCode);
						} catch (Exception e) {
							System.out.println(e.getMessage() + "\n" + e.getCause());
						}
						if (empList.isEmpty()) {
							System.out.println("No Employee is in this Department");
						} else {
							empList.forEach(System.out::println);
						}
						break;
					case 7:
						System.out.println(
								"******************************Going to Previous Menu******************************");
						break;
					}
				} while (option != 7);
				break;

			case 4:
				System.out
						.println("**********************************************************************************");
				System.out
						.println("*********************************Bank App Closed**********************************");
				System.out
						.println("**********************************************************************************");
				break;
			default:
				break;
			}
		} while (choice != 4);

	}

}
