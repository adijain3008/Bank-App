package com.mindtree.bank.exception.daoException.customerDaoException;

import com.mindtree.bank.exception.daoException.DaoException;

public class CustomerDaoException extends DaoException {
	private static final long serialVersionUID = 1L;

	public CustomerDaoException() {
		super();
	}

	public CustomerDaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CustomerDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CustomerDaoException(String arg0) {
		super(arg0);
	}

	public CustomerDaoException(Throwable arg0) {
		super(arg0);
	}
}