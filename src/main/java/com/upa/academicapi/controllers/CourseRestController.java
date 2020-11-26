package com.upa.academicapi.controllers;

import java.util.ArrayList;
import java.util.List;

import com.upa.academicapi.dao.api.CourseDaoAPI;
import com.upa.academicapi.models.Course;
import com.upa.academicapi.service.api.CourseServiceAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * I set the routes for the API, simple by following this example:
 * http//localhost:300/api/route-to-specify
 */
@RestController
@RequestMapping("/api")
public class CourseRestController {

    @Autowired
    private CourseServiceAPI repository;

    @Autowired
    private CourseDaoAPI repositoryDao;

    /**
     * 
     * @return
     */
    @GetMapping(value = "/course")
    public ResponseEntity<List<Course>> getAll() {
        List<Course> courses = this.repository.getAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    /**
     * 
     * @param id
     * @return
     */
    @GetMapping(value = "/course/{id}")
    public ResponseEntity<Course> getOne(@PathVariable Long id) {
        Course course = this.repository.getOne(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    /**
     * 
     * @param entity
     * @return
     */
    @PostMapping(value = "/course")
    public ResponseEntity<Course> save(@RequestBody Course entity) {
        Course newCourse = this.repository.save(entity);
        return new ResponseEntity<>(newCourse, HttpStatus.OK);
    }

    /**
     * 
     * @param entity
     * @return
     */
    @PostMapping(value="/courses")
    public ResponseEntity<List<Course>> save(@RequestBody List<Course> entity) {
        List<Course> courses = new ArrayList<>();
        entity.forEach(course -> courses.add(repository.save(course)));
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
    
    /**
     * 
     * @param entity
     * @param id
     * @return
     */
    @PutMapping(value = "/course/{id}")
    public ResponseEntity<Course> update(@RequestBody Course entity, @PathVariable Long id) {
        Course putcourse = this.repositoryDao.findById(id).map(course -> {
            course.setCourseName(entity.getCourseName());

            return this.repository.save(course);
        }).orElseGet(() -> {
            entity.setIdCourse(id);

            return this.repository.save(entity);
        });

        return new ResponseEntity<>(putcourse, HttpStatus.OK);
    }

    /**
     * 
     * @param id
     * @return
     */
    @DeleteMapping(value = "/course/{id}")
    public ResponseEntity<Course> delete(@PathVariable Long id) {
        this.repository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
