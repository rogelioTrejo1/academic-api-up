package com.upa.academicapi.controllers;

import java.util.ArrayList;
import java.util.List;

import com.upa.academicapi.dao.api.StudentDaoAPI;
import com.upa.academicapi.models.Student;
import com.upa.academicapi.service.api.StudentServiceAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * I set the routes for the API, simple by following this example:
 * http//localhost:300/api/route-to-specify
 */
@RestController
@RequestMapping(value = "/api")
public class StudentRestController {

    @Autowired
    private StudentServiceAPI repository;

    @Autowired
    private StudentDaoAPI repositoryDao;

    /**
     * 
     * @return
     */
    @GetMapping(value = "/student")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = this.repository.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /**
     * 
     * @param id
     * @return
     */
    @GetMapping(value = "/student/{id}")
    public ResponseEntity<Student> getOne(@PathVariable String id) {
        Student student = this.repository.getOne(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    /**
     * 
     * @param entity
     * @return
     */
    @PostMapping(value = "/student")
    public ResponseEntity<Student> save(@RequestBody Student entity) {
        Student student = this.repository.save(entity);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    /**
     * 
     */
    @PostMapping(value = "/students")
    public ResponseEntity<List<Student>> save(@RequestBody List<Student> entity) {
        List<Student> students = new ArrayList<>();
        entity.forEach(student -> students.add(repository.save(student)));
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /**
     * 
     * @param up
     * @param entity
     * @return
     */
    @PutMapping(value = "/student/{up}")
    public ResponseEntity<Student> update(@PathVariable String up, @RequestBody Student entity) {
        Student putStudent = this.repositoryDao.findById(up).map(student -> {
            student.setFisrtNames(entity.getFisrtNames());
            student.setLastNames(entity.getLastNames());
            student.setAddress(entity.getAddress());
            student.setCareer(entity.getCareer());
            student.setGrade(entity.getGrade());
            student.setGroup(entity.getGroup());

            return this.repository.save(student);
        }).orElseGet(() -> {
            entity.setUp(up);

            return this.repository.save(entity);
        });

        return new ResponseEntity<>(putStudent, HttpStatus.OK);
    }

    /**
     * 
     * @param up
     * @return
     */
    @DeleteMapping(value = "/student/{up}")
    public ResponseEntity<Student> delete(@PathVariable String up) {
        this.repository.delete(up);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
