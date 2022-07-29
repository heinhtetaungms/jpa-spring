package com.ace;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {
	
	
	//curl -X POST -H 'Content-Type: application/json' -d '{"code":"JAVA","name":"Java SE Course","fees":"200000"}' http://localhost:8080/jpa-spring/courses/all 
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Runner.class);
		context.registerShutdownHook();
		
	}
}
