package com.crud_backend_prueba_tecnica.app.service;

import java.util.List;

import com.crud_backend_prueba_tecnica.app.entity.CustomerEntity;

public interface CustomerService {
	CustomerEntity create(CustomerEntity customer);

	List<CustomerEntity> findAll();

	CustomerEntity findById(Long id);

	CustomerEntity update(Long id, CustomerEntity customer);

	void delete(Long id);
}
