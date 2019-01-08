package com.mindtree.bank.exception.daoException.bankDaoException;

import com.mindtree.bank.exception.daoException.DaoException;

public class BankDaoException extends DaoException {
	private static final long serialVersionUID = 1L;

	public BankDaoException() {
		super();
	}

	public BankDaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public BankDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BankDaoException(String arg0) {
		super(arg0);
	}

	public BankDaoException(Throwable arg0) {
		super(arg0);
	}
}