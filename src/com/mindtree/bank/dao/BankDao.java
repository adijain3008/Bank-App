package com.mindtree.bank.dao;

import java.util.List;

import com.mindtree.bank.entity.Bank;
import com.mindtree.bank.exception.daoException.bankDaoException.BankDaoException;

public interface BankDao {

	String addBank(Bank bank) throws BankDaoException;
	Bank getBankById(int bankCode) throws BankDaoException;
	List<Bank> getAllBanks() throws BankDaoException;
	String updateBank(Bank updatedBank) throws BankDaoException;
	String deleteBankById(int bankCode) throws BankDaoException;
}
