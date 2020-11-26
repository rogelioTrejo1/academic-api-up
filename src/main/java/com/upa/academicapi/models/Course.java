package com.upa.academicapi.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    @Column(name = "id_course")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long idCourse;

    @Column(name = "course_name")
    private String courseName;

    // Table Relationships
    @OneToMany(mappedBy = "course", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Qualification> qualifications;

    public Course() {
    }

    /**
     * Create a new Course
     * @param courseName Course Name
     */
    public Course(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Get All Qualifications that The course 
     * @return
     */
    public List<Qualification> getQualifications() {
        return qualifications;
    }

    /**
     * Set a list of Qualifications of the Course
     * @param qualifications Course's List Qualifications
     */
    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    /**
     * Set the Identify of the Course
     * @param idCourse Couser's ID
     */
    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    /**
     * Get the Identify of the Course
     * @return Course's ID
     */
    public Long getIdCourse() {
        return idCourse;
    }

    /**
     * Get the Name of the Couse
     * @return Course's Name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Set the Name of the Course
     * @param courseName Course's Name
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
