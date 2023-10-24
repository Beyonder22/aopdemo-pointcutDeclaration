package com.luv2code.aopdemo;

import static org.mockito.ArgumentMatchers.booleanThat;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.luv2code.aopdemo.DAO.AccountDAO;
import com.luv2code.aopdemo.DAO.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,MembershipDAO theMembershipDAO,TrafficFortuneService theTrafficFortuneService) {
		return runner -> {
//			demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);
//			demoTheAfterReturningAdvice(theAccountDAO);
//			demoTheAfterThrowingAdvice(theAccountDAO);
//			demoTheAfterAdvice(theAccountDAO);
//			demoTheAroundAdvice(theTrafficFortuneService);
//			demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		};
	}
	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {
System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");
		
		System.out.println("Calling getFortune()");
		
		boolean tripWire = true;
		
		String data = theTrafficFortuneService.getFortune(tripWire);
		
		System.out.println("\nMy fortune is: "+data);
		
		System.out.println("Finished");
	}
	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
		
		System.out.println("Calling getFortune()");
		
		boolean tripWire = true;
		
		String data = theTrafficFortuneService.getFortune(tripWire);
		
		System.out.println("\nMy fortune is: "+data);
		
		System.out.println("Finished");
		
	}
	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");
		
		System.out.println("Calling getFortune()");
		
		String data = theTrafficFortuneService.getFortune();
		
		System.out.println("\nMy fortune is: "+data);
		
		System.out.println("Finished");
	}
	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		try {
			boolean tripeWire = false;
			theAccountDAO.findAccounts(tripeWire);
		}catch (Exception exc) {
			System.out.println("\n\nMain Program: ... caught exception: "+exc);
		}
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");
		
	}
	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		try {
			boolean tripeWire = true;
			theAccountDAO.findAccounts(tripeWire);
		}catch (Exception exc) {
			System.out.println("\n\nMain Program: ... caught exception: "+exc);
		}
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");
		
	}
	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = theAccountDAO.findAccounts();
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}
	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MembershipDAO theMembershipDAO) {
		Account myAccount = new Account();
		myAccount.setName("Aman");
		myAccount.setLevel("Legend");
		
		theAccountDAO.addAccount(myAccount,true);
		theMembershipDAO.addAccount();
		
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		theAccountDAO.doWork();
		theMembershipDAO.goToSleep();
	}
}
