package com.crud_backend_prueba_tecnica.app.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerUpdateRequest(@NotBlank String firstName, @NotBlank String lastName, String company, String city,
		String country, String phone1, String phone2, @Email String email, @NotNull LocalDate subscriptionDate,
		String website) {

}
