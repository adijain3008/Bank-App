package com.mindtree.bank.exception;

public class BankAppException extends Exception {
	private static final long serialVersionUID = 1L;

	public BankAppException() {
		super();
	}

	public BankAppException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public BankAppException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BankAppException(String arg0) {
		super(arg0);
	}

	public BankAppException(Throwable arg0) {
		super(arg0);
	}

}