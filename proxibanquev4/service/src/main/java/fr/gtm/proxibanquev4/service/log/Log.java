package fr.gtm.proxibanquev4.service.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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
	
	FileHandler fh;
	
	@Pointcut("execution(* fr.gtm.proxibanquev4.service.*.*.*(..))")
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
		
		try {  

	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("C:/Users/Adminl/Documents/loggin.log", true);  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }
		
	}

}


