package com.upa.academicapi.controllers;

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

@RestController
@RequestMapping(value = "/api")
public class StudentRestController {

    @Autowired
    private StudentServiceAPI repository;

    @Autowired
    private StudentDaoAPI repositoryDao;

    @GetMapping(value = "/student")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = this.repository.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/student/{id}")
    public ResponseEntity<Student> getOne(@PathVariable String id) {
        Student student = this.repository.getOne(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping(value = "/student")
    public ResponseEntity<Student> save(@RequestBody Student entity) {
        Student newStudent = this.repository.save(entity);
        return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }

    @PutMapping(value = "student/{up}")
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

    @DeleteMapping(value = "/student/{up}")
    public ResponseEntity<Student> delete(@PathVariable String up) {
        this.repository.delete(up);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}