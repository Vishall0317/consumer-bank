package com.consumerbank.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumerbank.dto.CustomerRequestDTO;
import com.consumerbank.dto.CustomerResponse;
import com.consumerbank.dto.CustomerResponseDTO;
import com.consumerbank.entity.Customer;
import com.consumerbank.repo.CustomerRepository;
import com.consumerbank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public boolean saveCustomerData(CustomerRequestDTO customerRequestDTO) {
	
		Customer customer=new Customer();

		BeanUtils.copyProperties(customerRequestDTO, customer);
		
		 Customer savedCustomer=customerRepository.save(customer);
		 if(savedCustomer !=null) return true;
		 return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<CustomerResponseDTO> getCustomersDetails() {
		
		List<CustomerResponseDTO> customerResponseList=new ArrayList<>();
		Iterator iterator=customerRepository.findAll().iterator();
		
		while(iterator.hasNext()) {
			CustomerResponseDTO responseDTO=new CustomerResponseDTO();
			BeanUtils.copyProperties(iterator.next(), responseDTO);
			customerResponseList.add(responseDTO);
		}
		return customerResponseList;
	}



	@Override
	public CustomerResponse getCustomersDetails(Integer customerId) {
	
		return customerRepository.findCustomerBycustomerId(customerId);
		
	
	}
	
}
