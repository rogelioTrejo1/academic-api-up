package com.upa.academicapi.dao.api;

import com.upa.academicapi.models.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentDaoAPI extends CrudRepository<Student, String> {
    /**
     * The generation of a "DAO" is to establish all the methods, which may occupy
     * all the basic methods of a "CRUD", this so that the framework is responsible
     * for making the statement "SQL" and give us functions to not write a single
     * line of "SQL"
     */
}
