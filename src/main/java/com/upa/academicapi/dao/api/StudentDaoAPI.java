package com.upa.academicapi.dao.api;

import com.upa.academicapi.models.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentDaoAPI extends CrudRepository<Student, String> {
    
}
