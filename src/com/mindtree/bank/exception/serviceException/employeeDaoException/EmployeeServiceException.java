package com.mindtree.bank.exception.serviceException.employeeDaoException;

import com.mindtree.bank.exception.serviceException.ServiceException;

public class EmployeeServiceException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public EmployeeServiceException() {
		super();
	}

	public EmployeeServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public EmployeeServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EmployeeServiceException(String arg0) {
		super(arg0);
	}

	public EmployeeServiceException(Throwable arg0) {
		super(arg0);
	}
}