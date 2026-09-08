package com.crud_backend_prueba_tecnica.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig{
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**") // Aplica a todas las rutas que inicien con /api/
						.allowedOrigins("http://localhost:4200") // URL de tu servidor de Angular
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
						.allowedHeaders("*") // Permite todas las cabeceras
						.allowCredentials(true) // Obligatorio si manejas cookies o sesiones
						.maxAge(3600); // Tiempo en segundos que el navegador guarda la configuración (1 hora)
			}
		};
	}
}
