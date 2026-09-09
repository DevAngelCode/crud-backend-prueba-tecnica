package com.crud_backend_prueba_tecnica.app.service;

import java.util.List;

import com.crud_backend_prueba_tecnica.app.dto.reponse.CustomerResponse;
import com.crud_backend_prueba_tecnica.app.dto.reponse.MessageResponse;
import com.crud_backend_prueba_tecnica.app.dto.reponse.PageResponse;
import com.crud_backend_prueba_tecnica.app.dto.request.CustomerCreateRequest;
import com.crud_backend_prueba_tecnica.app.dto.request.CustomerUpdateRequest;

public interface CustomerService {
	MessageResponse create(CustomerCreateRequest request);

	MessageResponse update(Long id, CustomerUpdateRequest request);

	PageResponse<CustomerResponse> findAll(int page, int size, String customerId);

	CustomerResponse findById(Long id);

	MessageResponse delete(Long id);
}
