package com.sachin.springdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sachin.springdemo.services.PaymentService;

@SpringBootTest
class SpringDemoCoreApplicationTests {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private ArithmaticeOperationImpl arithmaticeOperationImpl;
	
	@Test
	void testDependencyInjection() {
		assertNotNull(paymentService);
	}
	
	@Test 
	void testArithmaticOperation() {
		assertNotNull(arithmaticeOperationImpl.addition(10, 20));
		assertEquals(30, arithmaticeOperationImpl.addition(10, 20));
	}

}
