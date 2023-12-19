package com.javatechie.ps.api.service;

import java.util.Random;
import java.util.UUID;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.javatechie.ps.api.entity.Payment;
import com.javatechie.ps.api.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	private Logger log=Logger.getLogger(PaymentService.class);

	public Payment doPayment(Payment payment) throws JsonProcessingException {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		log.info("PaymentService transactionRequest : {}",new ObjectMapper().writeValueAsString(payment), null);
		return paymentRepository.save(payment);
	}

	
	public String paymentProcessing() {
		//api should be third party payment gateway(paypal,paytm)
		return new Random().nextBoolean()?"success":"false";
	}


	public Payment findByOrderId(int orderId) throws JsonProcessingException {
		Payment payment=paymentRepository.findByOrderId(orderId);
		log.info("PaymentService findByOrderId : {}",new ObjectMapper().writeValueAsString(payment), null);
		return payment;
	}

}
