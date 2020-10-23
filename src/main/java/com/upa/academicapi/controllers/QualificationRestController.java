package com.upa.academicapi.controllers;

import java.util.ArrayList;
import java.util.List;

import com.upa.academicapi.dao.api.QualificationDaoAPI;
import com.upa.academicapi.models.Qualification;
import com.upa.academicapi.service.api.QualificationServiceAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QualificationRestController {

    @Autowired
    private QualificationServiceAPI repository;

    @Autowired
    private QualificationDaoAPI repositoryDao;

    @GetMapping(value = "/qualification")
    public ResponseEntity<List<Qualification>> getAll() {
        List<Qualification> qualifications = this.repository.getAll();
        return new ResponseEntity<>(qualifications, HttpStatus.OK);
    }

    @GetMapping(value = "/qualification/{id}")
    public ResponseEntity<Qualification> getOne(@PathVariable Long id) {
        Qualification qualification = this.repository.getOne(id);
        return new ResponseEntity<>(qualification, HttpStatus.OK);
    }

    @PostMapping(value = "/qualification")
    public ResponseEntity<Qualification> save(@RequestBody Qualification entity) {
        Qualification qualification = this.repository.save(entity);
        return new ResponseEntity<>(qualification, HttpStatus.OK);
    }

    @PostMapping(value = "/qualifications")
    public ResponseEntity<List<Qualification>> save(@RequestBody List<Qualification> entities) {
        List<Qualification> qualifications = new ArrayList<>();
        entities.forEach(qualification -> qualifications.add(this.repository.save(qualification)));
        return new ResponseEntity<>(qualifications, HttpStatus.OK);
    }

    @PutMapping(value = "/qualification/{id}")
    public ResponseEntity<Qualification> update(@RequestBody Qualification entity, @PathVariable Long id) {
        Qualification putQualification = this.repositoryDao.findById(id).map(qualification -> {
            qualification.setCalifUnit1(entity.getCalifUnit1());
            qualification.setCalifUnit2(entity.getCalifUnit2());
            qualification.setAttendances(entity.getAttendances());

            return this.repository.save(qualification);
        }).orElseGet(() -> {
            entity.setIdQualification(id);

            return this.repository.save(entity);
        });

        return new ResponseEntity<>(putQualification, HttpStatus.OK);
    }

    @DeleteMapping(value = "/qualification/{id}")
    public ResponseEntity<Qualification> delete(@PathVariable Long id) {
        this.repository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
