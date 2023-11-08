package com.consumerbank.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumerbank.dto.TransactionRequestDTO;
import com.consumerbank.dto.TransactionResponseDTO;
import com.consumerbank.entity.Account;
import com.consumerbank.entity.Transaction;
import com.consumerbank.exception.CustomerNotFoundException;
import com.consumerbank.repo.AccountRepository;
import com.consumerbank.repo.CustomerRepository;
import com.consumerbank.repo.TransactionRepository;
import com.consumerbank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public TransactionResponseDTO saveTransactionData(TransactionRequestDTO transactionRequestDTO) {

		Optional<Account> optionalAccount=accountRepository.findById(transactionRequestDTO.getAccountId());
		if(optionalAccount.isEmpty()) throw new CustomerNotFoundException("Account doesn't exist for the id "+
				transactionRequestDTO.getAccountId());
		
		Transaction transaction= new Transaction();
		BeanUtils.copyProperties(transactionRequestDTO, transaction);
		
		transaction=transactionRepository.save(transaction);
		
		TransactionResponseDTO responseDTO = new TransactionResponseDTO();
		BeanUtils.copyProperties(transaction, responseDTO);
		return responseDTO;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<TransactionResponseDTO> getTransactionsDetails() {
		List<TransactionResponseDTO> transactionResponseList=new ArrayList<>();
		Iterator iterator=transactionRepository.findAll().iterator();
		
		while(iterator.hasNext()) {
			TransactionResponseDTO responseDTO=new TransactionResponseDTO();
			BeanUtils.copyProperties(iterator.next(), responseDTO);
			transactionResponseList.add(responseDTO);
		}
		return transactionResponseList;
	}

	@Override
	public TransactionResponseDTO getTransactionsDetails(Integer transactionId) {
	
		Transaction transaction= new Transaction();
		TransactionResponseDTO transactionResponseDTO=new TransactionResponseDTO();
		
		Optional<Transaction> optionalTransaction=transactionRepository.findById(transactionId);
		
		if(optionalTransaction.isPresent()) {
			transaction=optionalTransaction.get();
		}
		
		BeanUtils.copyProperties(transaction, transactionResponseDTO);
		return transactionResponseDTO;
	}


}
