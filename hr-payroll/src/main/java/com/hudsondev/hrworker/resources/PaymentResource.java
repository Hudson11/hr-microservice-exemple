package com.hudsondev.hrworker.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hudsondev.hrworker.entities.Payment;
import com.hudsondev.hrworker.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment 
		(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = this.paymentService.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}

}
