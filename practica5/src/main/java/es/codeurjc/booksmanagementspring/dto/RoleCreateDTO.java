package es.codeurjc.booksmanagementspring.dto;

import es.codeurjc.booksmanagementspring.model.ERoles;

public record RoleCreateDTO(
        ERoles name
) {
}