package com.mindtree.bank.service.serviceimpl;

import java.util.List;

import com.mindtree.bank.dao.BankDao;
import com.mindtree.bank.dao.daoimpl.BankDaoImpl;
import com.mindtree.bank.entity.Bank;
import com.mindtree.bank.exception.daoException.bankDaoException.BankDaoException;
import com.mindtree.bank.exception.serviceException.bankServiceException.BankServiceException;
import com.mindtree.bank.service.BankService;

public class BankServiceImpl implements BankService {

	BankDao bankDao = new BankDaoImpl();

	@Override
	public String addBank(Bank bank) throws BankServiceException {
		for (Bank bnk : this.getAllBanks()) {
			if (bank.getBankCode() == bnk.getBankCode()) {
				throw new BankServiceException("This Bank Code already exists");
			}
		}
		try {
			return bankDao.addBank(bank);
		} catch (BankDaoException e) {
			throw new BankServiceException(e);
		}
	}

	@Override
	public Bank getBankById(int bankCode) throws BankServiceException {
		try {
			return bankDao.getBankById(bankCode);
		} catch (BankDaoException e) {
			throw new BankServiceException(e);
		}
	}

	@Override
	public List<Bank> getAllBanks() throws BankServiceException {
		try {
			return bankDao.getAllBanks();
		} catch (BankDaoException e) {
			throw new BankServiceException(e);
		}
	}

	@Override
	public String updateBank(Bank updatedBank) throws BankServiceException {
		try {
			return bankDao.updateBank(updatedBank);
		} catch (BankDaoException e) {
			throw new BankServiceException(e);
		}
	}

	@Override
	public String deleteBankById(int bankCode) throws BankServiceException {
		try {
			return bankDao.deleteBankById(bankCode);
		} catch (BankDaoException e) {
			throw new BankServiceException(e);
		}
	}
}