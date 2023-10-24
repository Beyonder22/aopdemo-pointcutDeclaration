package com.luv2code.aopdemo.DAO;

import java.util.List;

import com.luv2code.aopdemo.Account;

public interface AccountDAO {
	
	void addAccount(Account theAccount, boolean vipFlag);
	
	boolean doWork();
	
	public String getName();

	public void setName(String name);

	public String getServiceCode();
	
	public void setServiceCode(String serviceCodeString);
	
	public List<Account> findAccounts(boolean tripWire);
	
	public List<Account> findAccounts();
}
