package com.crud_backend_prueba_tecnica.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud_backend_prueba_tecnica.app.dto.reponse.CustomerResponse;
import com.crud_backend_prueba_tecnica.app.dto.reponse.MessageResponse;
import com.crud_backend_prueba_tecnica.app.dto.request.CustomerCreateRequest;
import com.crud_backend_prueba_tecnica.app.dto.request.CustomerUpdateRequest;
import com.crud_backend_prueba_tecnica.app.service.CustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerService customerService;

	@PostMapping
	public ResponseEntity<MessageResponse> create(@Valid @RequestBody CustomerCreateRequest request) {

		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(request));
	}

	@GetMapping
	public ResponseEntity<List<CustomerResponse>> findAll() {

		return ResponseEntity.ok(customerService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponse> findById(@PathVariable Long id) {

		CustomerResponse response = customerService.findById(id);

		if (response == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MessageResponse> update(@PathVariable Long id,
			@Valid @RequestBody CustomerUpdateRequest request) {

		MessageResponse response = customerService.update(id, request);

		if (response.message().equals("Cliente no encontrado")) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> delete(@PathVariable Long id) {

		MessageResponse response = customerService.delete(id);

		if (response.message().equals("Cliente no encontrado")) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(response);
	}
}
