package es.codeurjc.booksmanagementspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.booksmanagementspring.model.Role;

public interface RoleRepository extends JpaRepository <Role, Long>{

}
