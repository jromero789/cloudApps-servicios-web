package es.codeurjc.booksmanagementspring.repository;

import es.codeurjc.booksmanagementspring.model.User;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAll(Pageable pageable);
    Optional<User> findByNick(String nick);
    Boolean existsByNick(String nick);
    Boolean existsByEmail(String email);
}
