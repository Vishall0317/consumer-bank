package com.consumerbank.service;

import java.util.List;

import com.consumerbank.dto.AccountRequestDTO;
import com.consumerbank.dto.AccountResponseDTO;
import com.consumerbank.dto.AccountResponse;

public interface AccountService {

	AccountResponseDTO saveAccountData(AccountRequestDTO accountRequestDTO);

	List<AccountResponseDTO> getAccountsDetails();

	AccountResponse getAccountsDetails(Integer accountId);

}
