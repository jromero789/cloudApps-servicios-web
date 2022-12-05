package com.cloudapps.practica2.username;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsernameRepository extends JpaRepository<Username, Long> {
    
    Page<Username> findAll(Pageable page);
}
