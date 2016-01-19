package fr.gtm.proxibanquev4.dao_springdata.log;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Log {
	
	long t1;
	long t2;
	Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Pointcut("execution(* fr.gtm.proxibanquev4.dao_springdata.client.*.*(..))")
	public void operation(){}
	
	@Before("operation()")
	public void avant(JoinPoint thisJoinPoint){
		t1=System.currentTimeMillis();
		logger.info("***********************************");
		logger.info("Avant "+thisJoinPoint.getSignature());
	}
	
	@After("operation()")
	public void logApres(JoinPoint thisJoinPoint){
		t2=System.currentTimeMillis();
		logger.info("***********************************");
		logger.info("Apres "+thisJoinPoint.getSignature()+" Durée d'execution : " + (t2-t1));
	}
	
	@AfterReturning(pointcut = "operation()", returning= "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		logger.info("************************************");
		logger.info("METHODE : " + joinPoint.getSignature().getName());
		logger.info("VALEUR DE RETOUR DE LA METHODE : " + result);
		logger.info("************************************");

	   }

}
