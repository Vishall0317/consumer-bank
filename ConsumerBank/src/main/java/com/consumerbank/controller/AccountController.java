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

import com.consumerbank.dto.AccountRequestDTO;
import com.consumerbank.dto.AccountResponseDTO;
import com.consumerbank.dto.AccountResponse;
import com.consumerbank.service.AccountService;

@RestController
@Validated
public class AccountController {

	@Autowired
	AccountService accountService;
	
	/*
	 * save account details
	 */
	
	@PostMapping("/accounts")
	public ResponseEntity<AccountResponseDTO> saveAccountData(@Valid @RequestBody AccountRequestDTO accountRequestDTO){
		
		AccountResponseDTO responseDTO = accountService.saveAccountData(accountRequestDTO);
		return new ResponseEntity<AccountResponseDTO> (responseDTO, HttpStatus.CREATED);
		
	}
	
	/*
	 * get all account details
	 */
	
	@GetMapping("/accounts")
	public List<AccountResponseDTO> getAccountsDetails(){
		return accountService.getAccountsDetails();
	}
	
	/*
	 * get single account details by id
	 */
	
	@GetMapping("/accounts/{accountId}")
	public AccountResponse getAccountsDetails(@PathVariable Integer accountId){
		return accountService.getAccountsDetails(accountId);
	}
	
	


	
	
}
