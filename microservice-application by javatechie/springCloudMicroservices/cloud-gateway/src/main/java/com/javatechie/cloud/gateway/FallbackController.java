package com.javatechie.cloud.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

	@RequestMapping("/orderFallback")
	public Mono<String> orderServiceFallback(){
		return Mono.just("order service is taking too long or is down,please try later");
	}
	
	
	@RequestMapping("/paymentFallback")
	public Mono<String> paymentServiceFallback(){
		return Mono.just("payment service is taking too long or is down,please try later");
	}
}
