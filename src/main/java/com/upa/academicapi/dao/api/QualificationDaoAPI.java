package com.upa.academicapi.dao.api;

import com.upa.academicapi.models.Qualification;

import org.springframework.data.repository.CrudRepository;

public interface QualificationDaoAPI extends CrudRepository<Qualification, Long> {
    /**
     * The generation of a "DAO" is to establish all the methods, which may occupy
     * all the basic methods of a "CRUD", this so that the framework is responsible
     * for making the statement "SQL" and give us functions to not write a single
     * line of "SQL"
     */
}
