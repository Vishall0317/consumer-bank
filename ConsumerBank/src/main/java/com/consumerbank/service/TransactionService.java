package com.consumerbank.service;

import java.util.List;

import com.consumerbank.dto.TransactionRequestDTO;
import com.consumerbank.dto.TransactionResponseDTO;

public interface TransactionService {

	TransactionResponseDTO saveTransactionData(TransactionRequestDTO transactionRequestDTO);

	List<TransactionResponseDTO> getTransactionsDetails();

	TransactionResponseDTO getTransactionsDetails(Integer transactionId);

}
