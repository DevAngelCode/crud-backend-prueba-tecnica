package com.crud_backend_prueba_tecnica.app.dto.reponse;

import java.time.LocalDate;

public record CustomerResponse(Long id, String customerId, String firstName, String lastName, String company,
		String city, String country, String phone1, String phone2, String email, LocalDate subscriptionDate,
		String website) {

}
