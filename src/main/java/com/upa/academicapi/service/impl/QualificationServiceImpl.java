package com.upa.academicapi.service.impl;

import com.upa.academicapi.commons.GenericServiceAPIImpl;
import com.upa.academicapi.dao.api.QualificationDaoAPI;
import com.upa.academicapi.models.Qualification;
import com.upa.academicapi.service.api.QualificationServiceAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class QualificationServiceImpl extends GenericServiceAPIImpl<Qualification, Long>
        implements QualificationServiceAPI {
    
    @Autowired
    private QualificationDaoAPI repository;

    @Override
    public CrudRepository<Qualification, Long> getDao() {
        return this.repository;
    }

    
}