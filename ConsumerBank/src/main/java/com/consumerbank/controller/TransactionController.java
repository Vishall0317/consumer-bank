package com.consumerbank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consumerbank.dto.TransactionRequestDTO;
import com.consumerbank.dto.TransactionResponseDTO;
import com.consumerbank.service.TransactionService;

@RestController
@Validated
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	/*
	 * save Transaction details
	 */
	
	@PostMapping("/transactions")
	public ResponseEntity<TransactionResponseDTO> saveTransactionData(@Valid @RequestBody TransactionRequestDTO transactionRequestDTO){
		
		TransactionResponseDTO responseDTO = transactionService.saveTransactionData(transactionRequestDTO);
		return new ResponseEntity<TransactionResponseDTO> (responseDTO, HttpStatus.CREATED);
		
	}
	
	/*
	 * get all transactions details
	 */
	
	@GetMapping("/transactions")
	public List<TransactionResponseDTO> getTransactionsDetails(){
		return transactionService.getTransactionsDetails();
	}
	
	/*
	 * get single transaction details by id
	 */
	
	@GetMapping("/transactions/{transactionId}")
	public TransactionResponseDTO getTransactionsDetails(@PathVariable Integer transactionId){
		return transactionService.getTransactionsDetails(transactionId);
	}
	
}
