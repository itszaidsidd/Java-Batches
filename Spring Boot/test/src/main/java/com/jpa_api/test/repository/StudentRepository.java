package com.jpa_api.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.jpa_api.test.entity.Students;

@Component 
public interface StudentRepository extends JpaRepository<Students,Long> {
    
}
