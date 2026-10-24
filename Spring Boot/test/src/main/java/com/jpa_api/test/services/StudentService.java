package com.jpa_api.test.services;

import java.util.List;
import java.util.Optional;

import com.jpa_api.test.entity.Students;

public interface StudentService {
    public boolean addStudent(Students std);
    public List<Students> getAll();
    public Optional<Students> getById(Long id);
    public boolean updateStudent(Long id, Students std);
    public boolean deleteStudent(Long id);


    

}
