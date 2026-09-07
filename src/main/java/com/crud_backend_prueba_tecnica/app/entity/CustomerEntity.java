package com.crud_backend_prueba_tecnica.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "customer_id", nullable = false, length = 50)
	private String customerId;

	@Column(name = "first_name", nullable = false, length = 100)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 100)
	private String lastName;

	@Column(name = "company", length = 150)
	private String company;

	@Column(name = "city", length = 100)
	private String city;

	@Column(name = "country", length = 100)
	private String country;

	@Column(name = "phone_1", length = 50)
	private String phone1;

	@Column(name = "phone_2", length = 50)
	private String phone2;

	@Column(name = "email", length = 150)
	private String email;

	@Column(name = "subscription_date")
	private LocalDate subscriptionDate;

	@Column(name = "website", length = 255)
	private String website;
}
