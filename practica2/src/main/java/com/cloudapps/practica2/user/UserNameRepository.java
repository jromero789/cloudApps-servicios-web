package com.cloudapps.practica2.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNameRepository extends JpaRepository<UserName, Long> {
    
}
