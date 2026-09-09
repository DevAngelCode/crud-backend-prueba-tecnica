package com.crud_backend_prueba_tecnica.app.dto.reponse;

import java.util.List;

public record PageResponse<T>(List<T> content, int page, int size, long totalElements, int totalPages) {

}
