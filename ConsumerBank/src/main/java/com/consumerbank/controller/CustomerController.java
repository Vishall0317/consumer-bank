package com.consumerbank.controller;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consumerbank.dto.CustomerRequestDTO;
import com.consumerbank.dto.CustomerResponse;
import com.consumerbank.dto.CustomerResponseDTO;
import com.consumerbank.service.CustomerService;

@RestController
@Validated
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	/*
	 * save customer details
	 */
	
	@PostMapping("/customers")
	public ResponseEntity<String> saveCustomerData(@RequestBody CustomerRequestDTO customerRequestDTO){
	
		boolean response= customerService.saveCustomerData(customerRequestDTO);
		if(response) {
			return new ResponseEntity<String> ("customer data save successfully",HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String> ("customer data save unsuccessfull",HttpStatus.NOT_ACCEPTABLE);
		}


	}
	
	/*
	 * get all customer details
	 */
	
	@GetMapping("/customers")
	public List<CustomerResponseDTO> getCustomersDetails(){
		
		return customerService.getCustomersDetails();
	}
	
	/*
	 * get single customer details by id
	 */
	
//	@GetMapping("/customers/{customerId}")
//	public CustomerResponse getCustomersDetails(@PathVariable Integer customerId){
//		
//		return customerService.getCustomersDetails(customerId);
//	}
	
	
	
}












