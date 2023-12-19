package com.javatechie.os.api.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.os.api.common.Payment;
import com.javatechie.os.api.common.TransactionRequest;
import com.javatechie.os.api.common.TransactionResponse;
import com.javatechie.os.api.entity.Order;
import com.javatechie.os.api.repository.OrderRepository;

@Service
@RefreshScope
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	private String ENDPOINT_URL;
	
	private Logger log=Logger.getLogger(OrderService.class);
	
	public TransactionResponse saveOrder(TransactionRequest transactionRequest) throws JsonProcessingException{
		String response="";
		Order order = transactionRequest.getOrder();
		Payment payment = transactionRequest.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		
		log.info("OrderService transactionRequest : {}",new ObjectMapper().writeValueAsString(transactionRequest), null);
		//rest call
		Payment paymentResponse=restTemplate.postForObject(ENDPOINT_URL,payment,Payment.class);
		log.info("PaymentService response from OrderService transactionRequest : {}",new ObjectMapper().writeValueAsString(transactionRequest), null);
		
		response=paymentResponse.getPaymentStatus().equals("success")?"payment successful":"payment failed";
		
		
		 orderRepository.save(order);
		 
		 return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
	}
}
