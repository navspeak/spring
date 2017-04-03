package com.nav.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Logger is an aspect. It has aboutToTakePhoto() as an advice
@Component
@Aspect
public class Logger {
	
	// Method 1
	//	@Before("execution(void com.nav.spring.aop.Camera.snap())")
	//	public void aboutToTakePhoto() {
	//		System.out.println("About to take photo...");
	//	}
	
	// Method 2
	// Define a pointcut
	// give that to @Before
	
	@Pointcut("execution(* com.nav.spring.aop.Camera.snap())")
	//	@Pointcut("within(com.nav.spring.aop.*)")
	//@Pointcut("execution(void com.nav.spring.aop.Camera.snap(..))") //wildcard
	public void cameraSnap(){
		
	}
	
//	@Pointcut("execution(* com.nav.spring.aop.Camera.*(..))") //wildcard
//	public void cameraSnapForAll(){
//		
//	}
//	
//	@Pointcut("execution(* com.nav.spring.aop.Camera.snap(String))") //wildcard
//	//@Pointcut("execution(String com.nav.spring.aop.Camera.snap(String))") 
//	public void cameraSnapName(){
//		
//	}
//	
//	@Pointcut("execution(* com.nav.spring.aop.*.*(..))") //wildcard
//	//@Pointcut("execution(String com.nav.spring.aop.Camera.snap(String))") 
//	public void cameraRelatedAction(){
		
//	}
	//	@Before("cameraSnap()")
	//	public void aboutToTakePhoto() {
	//		System.out.println("About to take photo...");
	//	}
	
//	@Before("cameraSnapName()")
//	public void beforeAdviceForMethodsWithName() {
//		System.out.println("Before Advice for Methods with Name...");
//	}
//	
	@Before("cameraSnap()")
	public void beforeAdvice() {
		System.out.println("Before Advice...");
	}
	
	@After("cameraSnap()") // even after exception
	public void afterAdvice() {
		System.out.println("After Advice...");
	}
	
	@AfterReturning("cameraSnap()") // even after exception
	//@AfterThrowing("cameraSnap()") // only after exception
	public void afterAdviceWithNoException() {
		System.out.println("After Advice when normal run, no exception...");
	}
	
	@Around("cameraSnap()") 
	public void aroundAdvice(ProceedingJoinPoint p) {
		System.out.println("Around advice (before)...");
		
		try {
			p.proceed();
		} catch (Throwable e) { // if the joinpoint throws exception
			System.out.println("Exception in aroundAdvice " + e.getMessage());
		}
		
		System.out.println("Around advice (after)...");
	}
	
	
//	@Before("cameraRelatedAction()")
//    public void aboutToDoSomeCameraRelatedAction(){
//    	System.out.println("About to do some camera related action");
//    }
//	

}
