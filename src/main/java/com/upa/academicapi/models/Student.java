package com.upa.academicapi.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    public Student() {
    }

    /**
     * 
     * @param up
     * @param fisrtNames
     * @param lastNames
     * @param address
     * @param career
     * @param grade
     * @param group
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

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getFisrtNames() {
        return fisrtNames;
    }

    public void setFisrtNames(String fisrtNames) {
        this.fisrtNames = fisrtNames;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public char getGroup() {
        return group;
    }

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
        return Objects.hash(this.up, this.fisrtNames, this.lastNames, this.address, this.career, this.grade, this.group);
    }

    @Override
    public String toString() {
        return "Student { address=" + address + ", career=" + career + ", fisrtNames=" + fisrtNames + ", grade=" + grade
                + ", group=" + group + ", lastNames=" + lastNames + ", up=" + up + "}";
    }

}