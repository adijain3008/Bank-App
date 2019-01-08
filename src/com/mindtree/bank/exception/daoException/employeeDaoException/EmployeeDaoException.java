package com.mindtree.bank.exception.daoException.employeeDaoException;

import com.mindtree.bank.exception.daoException.DaoException;

public class EmployeeDaoException extends DaoException {
	private static final long serialVersionUID = 1L;

	public EmployeeDaoException() {
		super();
	}

	public EmployeeDaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public EmployeeDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EmployeeDaoException(String arg0) {
		super(arg0);
	}

	public EmployeeDaoException(Throwable arg0) {
		super(arg0);
	}
}