package com.upa.academicapi.service.impl;

import com.upa.academicapi.commons.GenericServiceAPIImpl;
import com.upa.academicapi.dao.api.CourseDaoAPI;
import com.upa.academicapi.models.Course;
import com.upa.academicapi.service.api.CourseServiceAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends GenericServiceAPIImpl<Course, Long> implements CourseServiceAPI {

    @Autowired
    private CourseDaoAPI repository;

    @Override
    public CrudRepository<Course, Long> getDao() {
        return repository;
    }
}
