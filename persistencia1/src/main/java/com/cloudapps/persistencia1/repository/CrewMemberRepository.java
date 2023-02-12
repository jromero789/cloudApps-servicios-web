package com.cloudapps.persistencia1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cloudapps.persistencia1.model.CrewMember;

public interface CrewMemberRepository extends JpaRepository<CrewMember, Long> {

    CrewMember findByEmployeeId(String EmployeeId);
}
