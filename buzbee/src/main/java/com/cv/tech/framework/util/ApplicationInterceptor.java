// $codepro.audit.disable
package com.cv.tech.framework.util;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationInterceptor {

	// Advice for all the controller & Service methods
	private Logger logger = Logger.getLogger(ApplicationInterceptor.class);

	@Pointcut("within(@org.springframework.stereotype.Service *)")
	public void serviceMethods() {
	}

	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controllerMethods() {
	}

	@Pointcut("execution(public * *(..))")
	public void publicMethods() {
	}

	@Before("(serviceMethods() || controllerMethods()) && publicMethods()")
	public void logMessageBefore(JoinPoint proceedingJoinPoint)
			throws Exception {
		logger.info("-> " + proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName() + ":"
				+ proceedingJoinPoint.getSignature().getName()
				+ "() paramters values : "
				+ Arrays.toString(proceedingJoinPoint.getArgs()));
	/*	proceedingJoinPoint.proceed();*/
/*
		logger.info("<- " + proceedingJoinPoint.getClass().getName() + ":"
				+ proceedingJoinPoint.getSignature().getName());*/
	}

	@After("(serviceMethods() || controllerMethods()) && publicMethods()")
	public void logMessageAfter(JoinPoint proceedingJoinPoint)
			throws Exception {
		logger.info("<- " +  proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName() + ":"
				+ proceedingJoinPoint.getSignature().getName());
	}

}
