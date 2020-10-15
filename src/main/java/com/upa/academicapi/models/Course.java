package com.upa.academicapi.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    @Column(name = "id_course")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id Long idCourse;

    @Column(name = "course_name")
    private String courseName;

    public Course() {
    }

    /**
     * 
     * @param courseName
     */
    public Course(String courseName) {
        this.courseName = courseName;
    }

    /**
     * 
     * @param idCourse
     */
    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    /**
     * 
     * @return
     */
    public Long getIdCourse() {
        return idCourse;
    }

    /**
     * 
     * @return
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Course))
            return false;

        Course course = (Course) o;

        return Objects.equals(this.idCourse, course.idCourse) && Objects.equals(this.courseName, course.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.idCourse, this.courseName);
    }

    @Override
    public String toString() {
        return "Course {courseName=" + courseName + ", idCourse=" + idCourse + "}";
    }

}