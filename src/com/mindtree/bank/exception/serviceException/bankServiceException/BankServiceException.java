package com.mindtree.bank.exception.serviceException.bankServiceException;

import com.mindtree.bank.exception.serviceException.ServiceException;

public class BankServiceException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public BankServiceException() {
		super();
	}

	public BankServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public BankServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BankServiceException(String arg0) {
		super(arg0);
	}

	public BankServiceException(Throwable arg0) {
		super(arg0);
	}
}