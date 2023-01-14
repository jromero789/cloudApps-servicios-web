package es.codeurjc.booksmanagementspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.booksmanagementspring.model.ERoles;
import es.codeurjc.booksmanagementspring.model.Role;

public interface RoleRepository extends JpaRepository <Role, Long>{
    Optional<Role> findByName(ERoles name);
}
