package com.upa.academicapi.dao.api;

import com.upa.academicapi.models.Qualification;

import org.springframework.data.repository.CrudRepository;

public interface QualificationDaoAPI extends CrudRepository<Qualification, Long> {
    
}
