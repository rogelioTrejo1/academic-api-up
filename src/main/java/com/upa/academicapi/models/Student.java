package com.upa.academicapi.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Column(name = "up")
    private @Id String up;

    @Column(name = "first_names")
    private String fisrtNames;

    @Column(name = "last_Names")
    private String lastNames;

    @Column(name = "address")
    private String address;

    @Column(name = "career")
    private String career;

    @Column(name = "grade")
    private int grade;

    @Column(name = "groupC")
    private char group;

    // Table Relationships
    @OneToMany(mappedBy = "student", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH })
    private List<Qualification> qualifications;

    public Student() {
    }

    /**
     * Create a new Student
     * 
     * @param up         ID of the students
     * @param fisrtNames Names of the student
     * @param lastNames  LastNames of the Student
     * @param address    Adress of the student
     * @param career     Career of the Student
     * @param grade      Grade of the Student
     * @param group      Group of the Student
     */
    public Student(String up, String fisrtNames, String lastNames, String address, String career, int grade,
            char group) {
        this.up = up;
        this.fisrtNames = fisrtNames;
        this.lastNames = lastNames;
        this.address = address;
        this.career = career;
        this.grade = grade;
        this.group = group;
    }

    /**
     * Get all Qualifications of the student
     * 
     * @return all Qualificatios
     */
    public List<Qualification> getQualifications() {
        return qualifications;
    }

    /**
     * Set the Qualifications of the student
     * 
     * @param qualifications List of Qualifications
     */
    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    /**
     * Get the Identifiy of the student
     * 
     * @return ID
     */
    public String getUp() {
        return up;
    }

    /**
     * Set the ID of the student
     * 
     * @param up ID of the student
     */
    public void setUp(String up) {
        this.up = up;
    }

    /**
     * Get the Names of the Student
     * 
     * @return the names
     */
    public String getFisrtNames() {
        return fisrtNames;
    }

    /**
     * Set the Names of the students
     * 
     * @param fisrtNames Names of the student
     */
    public void setFisrtNames(String fisrtNames) {
        this.fisrtNames = fisrtNames;
    }

    /**
     * Get the LastNames of the student
     * 
     * @return The LastNames
     */
    public String getLastNames() {
        return lastNames;
    }

    /**
     * Set the LastNames of the student
     * 
     * @param lastNames LastNames of the student
     */
    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    /**
     * Get the Adress of the student
     * 
     * @return the adress
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the adress of the student
     * 
     * @param address the adress of the student
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the Career of the student
     * 
     * @return the Career's Student
     */
    public String getCareer() {
        return career;
    }

    /**
     * Set the Career of the Student
     * 
     * @param career Student's Grade
     */
    public void setCareer(String career) {
        this.career = career;
    }

    /**
     * Get the Grade of the Student
     * 
     * @return Student's Grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Set the Grade of the Student
     * @param grade Student's Grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * Get the Group of the Student
     * @return Student's Group
     */
    public char getGroup() {
        return group;
    }

    /**
     * Set The group of the student
     * @param group Student's Group
     */
    public void setGroup(char group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Student))
            return false;

        Student student = (Student) o;

        return Objects.equals(this.up, student.up) && Objects.equals(this.fisrtNames, student.fisrtNames)
                && Objects.equals(this.lastNames, student.lastNames) && Objects.equals(this.address, student.address)
                && Objects.equals(this.career, student.career) && Objects.equals(this.grade, student.grade)
                && Objects.equals(this.group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.up, this.fisrtNames, this.lastNames, this.address, this.career, this.grade,
                this.group);
    }

    @Override
    public String toString() {
        return "Student { address=" + address + ", career=" + career + ", fisrtNames=" + fisrtNames + ", grade=" + grade
                + ", group=" + group + ", lastNames=" + lastNames + ", up=" + up + "}";
    }

}