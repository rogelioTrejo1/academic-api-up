package com.upa.academicapi.dao.api;

import com.upa.academicapi.models.Course;

import org.springframework.data.repository.CrudRepository;

public interface CourseDaoAPI extends CrudRepository<Course, Long> {
    
}
