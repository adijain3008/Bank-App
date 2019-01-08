package com.mindtree.bank.exception.utilException;

import com.mindtree.bank.exception.BankAppException;

public class DbUtilException extends BankAppException {
	private static final long serialVersionUID = 1L;

	public DbUtilException() {
		super();
	}

	public DbUtilException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public DbUtilException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DbUtilException(String arg0) {
		super(arg0);
	}

	public DbUtilException(Throwable arg0) {
		super(arg0);
	}
}