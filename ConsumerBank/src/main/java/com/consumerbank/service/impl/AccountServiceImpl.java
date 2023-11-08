package com.consumerbank.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumerbank.dto.AccountRequestDTO;
import com.consumerbank.dto.AccountResponse;
import com.consumerbank.dto.AccountResponseDTO;
import com.consumerbank.entity.Account;
import com.consumerbank.entity.Customer;
import com.consumerbank.exception.CustomerNotFoundException;
import com.consumerbank.repo.AccountRepository;
import com.consumerbank.repo.CustomerRepository;
import com.consumerbank.service.AccountService;

@Service		
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	@Override
	public AccountResponseDTO saveAccountData(AccountRequestDTO accountRequestDTO) {
		
		Optional<Customer> optionalCustomer=customerRepository.findById(accountRequestDTO.getCustomerId());
		if(optionalCustomer.isEmpty()) throw new CustomerNotFoundException("Customer doesn't exist for the id "+
				accountRequestDTO.getCustomerId());
		
		Account account= new Account();
		BeanUtils.copyProperties(accountRequestDTO, account);
		
		account=accountRepository.save(account);
		
		AccountResponseDTO responseDTO = new AccountResponseDTO();
		BeanUtils.copyProperties(account, responseDTO);
		return responseDTO;
		
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<AccountResponseDTO> getAccountsDetails() {
		List<AccountResponseDTO> accountResponseList=new ArrayList<>();
		Iterator iterator=accountRepository.findAll().iterator();
		
		while(iterator.hasNext()) {
			AccountResponseDTO responseDTO=new AccountResponseDTO();
			BeanUtils.copyProperties(iterator.next(), responseDTO);
			accountResponseList.add(responseDTO);
		}
		return accountResponseList;
	}
	
	@Override
	public AccountResponse getAccountsDetails(Integer accountId) {
		
		return accountRepository.findAccountByAccountId(accountId);
	
	}
	
	
}
