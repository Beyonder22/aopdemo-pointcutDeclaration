package com.luv2code.aopdemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOimpl implements MembershipDAO{

	@Override
	public void addAccount() {
		
		System.out.println(getClass()+": Doing my db work: adding a membership account");
		
	}

	@Override
	public void goToSleep() {
		System.out.println(getClass()+": going to sleep");

	}
	
}
