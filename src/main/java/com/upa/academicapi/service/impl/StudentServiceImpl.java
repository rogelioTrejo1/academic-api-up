package com.upa.academicapi.service.impl;

import com.upa.academicapi.commons.GenericServiceAPIImpl;
import com.upa.academicapi.dao.api.StudentDaoAPI;
import com.upa.academicapi.models.Student;
import com.upa.academicapi.service.api.StudentServiceAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends GenericServiceAPIImpl<Student, String> implements StudentServiceAPI {

    @Autowired
    private StudentDaoAPI repository;

    @Override
    public CrudRepository<Student, String> getDao() {
        return repository;
    }
    
}
