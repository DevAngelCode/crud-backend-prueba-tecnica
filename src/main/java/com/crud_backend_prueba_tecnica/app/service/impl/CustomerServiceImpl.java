package com.crud_backend_prueba_tecnica.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud_backend_prueba_tecnica.app.dto.reponse.CustomerResponse;
import com.crud_backend_prueba_tecnica.app.dto.reponse.MessageResponse;
import com.crud_backend_prueba_tecnica.app.dto.request.CustomerCreateRequest;
import com.crud_backend_prueba_tecnica.app.dto.request.CustomerUpdateRequest;
import com.crud_backend_prueba_tecnica.app.entity.CustomerEntity;
import com.crud_backend_prueba_tecnica.app.repository.CustomerRepository;
import com.crud_backend_prueba_tecnica.app.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	@Override
	@Transactional
	public MessageResponse create(CustomerCreateRequest request) {
		CustomerEntity customer = new CustomerEntity();

		customer.setCustomerId(request.customerId());
		customer.setFirstName(request.firstName());
		customer.setLastName(request.lastName());
		customer.setCompany(request.company());
		customer.setCity(request.city());
		customer.setCountry(request.country());
		customer.setPhone1(request.phone1());
		customer.setPhone2(request.phone2());
		customer.setEmail(request.email());
		customer.setSubscriptionDate(request.subscriptionDate());
		customer.setWebsite(request.website());

		customerRepository.save(customer);

		return new MessageResponse("Cliente creado correctamente");
	}

	@Override
	@Transactional
	public MessageResponse update(Long id, CustomerUpdateRequest request) {
		CustomerEntity customer = customerRepository.findById(id).orElse(null);

		if (customer == null) {
			return new MessageResponse("Cliente no encontrado");
		}

		customer.setFirstName(request.firstName());
		customer.setLastName(request.lastName());
		customer.setCompany(request.company());
		customer.setCity(request.city());
		customer.setCountry(request.country());
		customer.setPhone1(request.phone1());
		customer.setPhone2(request.phone2());
		customer.setEmail(request.email());
		customer.setSubscriptionDate(request.subscriptionDate());
		customer.setWebsite(request.website());

		customerRepository.save(customer);

		return new MessageResponse("Cliente actualizado correctamente");
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerResponse> findAll() {
		return customerRepository.findAll().stream().map(this::toResponse).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public CustomerResponse findById(Long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).map(this::toResponse).orElse(null);
	}

	@Override
	@Transactional
	public MessageResponse delete(Long id) {
		CustomerEntity customer = customerRepository.findById(id).orElse(null);

		if (customer == null) {
			return new MessageResponse("Cliente no encontrado");
		}

		customerRepository.delete(customer);

		return new MessageResponse("Cliente eliminado correctamente");
	}

	private CustomerResponse toResponse(CustomerEntity customer) {

		return new CustomerResponse(customer.getId(), customer.getCustomerId(), customer.getFirstName(),
				customer.getLastName(), customer.getCompany(), customer.getCity(), customer.getCountry(),
				customer.getPhone1(), customer.getPhone2(), customer.getEmail(), customer.getSubscriptionDate(),
				customer.getWebsite());
	}

}
