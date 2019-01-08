package com.mindtree.bank.exception.serviceException.customerServiceException;

import com.mindtree.bank.exception.serviceException.ServiceException;

public class CustomerServiceException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public CustomerServiceException() {
		super();
	}

	public CustomerServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CustomerServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CustomerServiceException(String arg0) {
		super(arg0);
	}

	public CustomerServiceException(Throwable arg0) {
		super(arg0);
	}
}