package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
	
	@Pointcut("execution(* com.luv2code.aopdemo.DAO.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.DAO.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.DAO.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !getter() && !setter()")
	public void forDaoPackageNoGetterSetter() {}

}
