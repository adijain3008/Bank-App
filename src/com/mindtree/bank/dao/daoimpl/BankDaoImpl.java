package com.mindtree.bank.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.bank.dao.BankDao;
import com.mindtree.bank.entity.Bank;
import com.mindtree.bank.exception.daoException.bankDaoException.BankDaoException;
import com.mindtree.bank.exception.utilException.DbUtilException;
import com.mindtree.bank.util.DbUtil;

public class BankDaoImpl implements BankDao {

	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement ps = null;

	@Override
	public String addBank(Bank bank) throws BankDaoException {
		String query = "insert into bank values(?,?,?,?)";
		String msg = "";
		try {
			conn = DbUtil.getConnection();

			ps = conn.prepareStatement(query);
			ps.setInt(1, bank.getBankCode());
			ps.setString(2, bank.getName());
			ps.setString(3, bank.getIfsc());
			ps.setString(4, bank.getBranch());

			ps.executeUpdate();

			msg = "Bank - " + bank.getName() + " detail added successfully";
			return msg;
		} catch (DbUtilException | SQLException e) {
			throw new BankDaoException("Unable to add Bank Details", e);
		}
	}

	@Override
	public Bank getBankById(int bankCode) throws BankDaoException {
		String query = "select * from bank where bank_code = " + bankCode;
		Bank bank = null;

		try {
			conn = DbUtil.getConnection();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				bank = new Bank();
				bank.setBankCode(rs.getInt(1));
				bank.setName(rs.getString(2));
				bank.setIfsc(rs.getString(3));
				bank.setBranch(rs.getString(4));
			}
		} catch (DbUtilException | SQLException e) {
			throw new BankDaoException("Unable to get Bank Details", e);
		}

		return bank;
	}

	@Override
	public List<Bank> getAllBanks() throws BankDaoException {
		List<Bank> banks = new ArrayList<>();

		String query = "select * from bank";
		Bank bank = null;
		try {
			conn = DbUtil.getConnection();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				bank = new Bank();
				bank.setBankCode(rs.getInt(1));
				bank.setName(rs.getString(2));
				bank.setIfsc(rs.getString(3));
				bank.setBranch(rs.getString(4));

				banks.add(bank);
			}
		} catch (DbUtilException | SQLException e) {
			throw new BankDaoException("Unable to get Bank Details", e);
		}
		return banks;
	}

	@Override
	public String updateBank(Bank updatedBank) throws BankDaoException {
		String query = "update bank set bank_name = ? where bank_code = ? ";
		String msg = "";
		try {
			conn = DbUtil.getConnection();

			ps = conn.prepareStatement(query);
			ps.setString(1, updatedBank.getName());
			ps.setInt(2, updatedBank.getBankCode());

			ps.executeUpdate();

			msg = "Bank - " + updatedBank.getName() + " data updated successfully";
		} catch (DbUtilException | SQLException e) {
			throw new BankDaoException("Unable to update Bank Details", e);
		}
		return msg;
	}

	@Override
	public String deleteBankById(int bankCode) throws BankDaoException {
		String query = "delete from bank where bank_code = " + bankCode;
		String msg = "";
		try {
			conn = DbUtil.getConnection();
			st = conn.createStatement();
			int row = st.executeUpdate(query);
			msg = (row > 0) ? "Deleted Bank successfully" : "This Bank doesn't exist";
		} catch (DbUtilException | SQLException e) {
			throw new BankDaoException("Unable to delete Bank Details", e);
		}
		return msg;
	}
}
