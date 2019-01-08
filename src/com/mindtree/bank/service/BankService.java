package com.mindtree.bank.service;

import java.util.List;

import com.mindtree.bank.entity.Bank;
import com.mindtree.bank.exception.serviceException.bankServiceException.BankServiceException;

public interface BankService {

	String addBank(Bank bank) throws BankServiceException;

	Bank getBankById(int bankCode) throws BankServiceException;

	List<Bank> getAllBanks() throws BankServiceException;

	String updateBank(Bank bank) throws BankServiceException;

	String deleteBankById(int bankCode) throws BankServiceException;
}