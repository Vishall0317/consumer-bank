package com.consumerbank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.consumerbank.dto.CustomerRequestDTO;
import com.consumerbank.dto.CustomerResponse;
import com.consumerbank.dto.CustomerResponseDTO;

@Service
public interface CustomerService {

	boolean saveCustomerData(CustomerRequestDTO customerRequestDTO);

	List<CustomerResponseDTO> getCustomersDetails();
	
	CustomerResponse getCustomersDetails(Integer customerId);

}
