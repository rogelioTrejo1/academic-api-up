package com.upa.academicapi.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "qualifications")
public class Qualification {

    @Column(name = "id_qualification")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long idQualification;

    @Column(name = "up")
    private String up;

    @Column(name = "id_course")
    private int idCourse;

    @Column(name = "calif_unit1")
    private float califUnit1;

    @Column(name = "calif_unit2")
    private float califUnit2;

    @Column(name = "attendances")
    private int attendances;

    // Table Relationships
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "up", insertable = false, updatable = false)
    private Student student;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_course", insertable = false, updatable = false)
    private Course course;

    public Qualification() {
    }

    /**
     * 
     * @param up
     * @param idCourse
     * @param califUnit1
     * @param califUnit2
     * @param attendances
     */
    public Qualification(String up, int idCourse, float califUnit1, float califUnit2, int attendances) {
        this.up = up;
        this.idCourse = idCourse;
        this.califUnit1 = califUnit1;
        this.califUnit2 = califUnit2;
        this.attendances = attendances;
    }

    /**
     * 
     * @param idQualification
     */
    public void setIdQualification(Long idQualification) {
        this.idQualification = idQualification;
    }

    /**
     * 
     * @return
     */
    public Long getIdQuQualification() {
        return idQualification;
    }

    /**
     * 
     * @return
     */
    public String getUp() {
        return up;
    }

    /**
     * 
     * @param up
     */
    public void setUp(String up) {
        this.up = up;
    }

    /**
     * 
     * @return
     */
    public int getIdCourse() {
        return idCourse;
    }

    /**
     * 
     * @param idCourse
     */
    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    /**
     * 
     * @return
     */
    public float getCalifUnit1() {
        return califUnit1;
    }

    /**
     * 
     * @param califUnit1
     */
    public void setCalifUnit1(float califUnit1) {
        this.califUnit1 = califUnit1;
    }

    /**
     * 
     * @return
     */
    public float getCalifUnit2() {
        return califUnit2;
    }

    /**
     * 
     * @param califUnit2
     */
    public void setCalifUnit2(float califUnit2) {
        this.califUnit2 = califUnit2;
    }

    /**
     * 
     * @return
     */
    public int getAttendances() {
        return attendances;
    }

    /**
     * 
     * @param attendances
     */
    public void setAttendances(int attendances) {
        this.attendances = attendances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Qualification))
            return false;

        Qualification qualification = (Qualification) o;

        return Objects.equals(this.idQualification, qualification.idQualification)
                && Objects.equals(this.up, qualification.up) && Objects.equals(this.idCourse, qualification.idCourse)
                && Objects.equals(this.califUnit1, qualification.califUnit1)
                && Objects.equals(this.califUnit2, qualification.califUnit1)
                && Objects.equals(this.attendances, qualification.attendances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.idQualification, this.up, this.idCourse, this.califUnit1, this.califUnit2,
                this.attendances);
    }

    @Override
    public String toString() {
        return "Qualification {attendances=" + attendances + ", califUnit1=" + califUnit1 + ", califUnit2=" + califUnit2
                + ", idCourse=" + idCourse + ", idQualification=" + idQualification + ", up=" + up + "}";
    }

}