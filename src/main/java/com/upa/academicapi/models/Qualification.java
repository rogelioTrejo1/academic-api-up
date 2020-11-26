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
    private Long idCourse;

    @Column(name = "calif_unit1")
    private float califUnit1;

    @Column(name = "calif_unit2")
    private float califUnit2;

    @Column(name = "attendances")
    private int attendances;

    // Table Relationships
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "up", insertable = false, updatable = false)
    private Student student;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "id_course", insertable = false, updatable = false)
    private Course course;

    public Qualification() {
    }

    /**
     * Create a new Qualification to save
     * 
     * @param up          Student's ID
     * @param idCourse    Course's ID
     * @param califUnit1  Qualification of the Unit 1
     * @param califUnit2  Qualification of the Unit 2
     * @param attendances Attendances of the Course
     */
    public Qualification(String up, Long idCourse, float califUnit1, float califUnit2, int attendances) {
        this.up = up;
        this.idCourse = idCourse;
        this.califUnit1 = califUnit1;
        this.califUnit2 = califUnit2;
        this.attendances = attendances;
    }

    /**
     * Set the Ithentify of the Qualification
     * 
     * @param idQualification Qualification's ID
     */
    public void setIdQualification(Long idQualification) {
        this.idQualification = idQualification;
    }

    /**
     * Get the Ithentify of the Qualification
     * 
     * @return Qualification's ID
     */
    public Long getIdQualification() {
        return idQualification;
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
     * Set the Identify of the Course
     * 
     * @param idCourse Couser's ID
     */
    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    /**
     * Get the Identify of the Course
     * 
     * @return Course's ID
     */
    public Long getIdCourse() {
        return this.idCourse;
    }

    /**
     * Return the Qualification of the first Unit
     * 
     * @return Unit 1 Qualification
     */
    public float getCalifUnit1() {
        return califUnit1;
    }

    /**
     * Set the Qualification of the first Unit
     * 
     * @param califUnit1 Firts Unit's Qualification
     */
    public void setCalifUnit1(float califUnit1) {
        this.califUnit1 = califUnit1;
    }

    /**
     * Get the Qualification of the second Unit
     * 
     * @return Second Unit's Qualification
     */
    public float getCalifUnit2() {
        return califUnit2;
    }

    /**
     * Set the Qualification of the second Unit
     * 
     * @param califUnit2 Second Unit's Qualification
     */
    public void setCalifUnit2(float califUnit2) {
        this.califUnit2 = califUnit2;
    }

    /**
     * Get the Attendances of the Unit
     * 
     * @return Unit's Attendence
     */
    public int getAttendances() {
        return attendances;
    }

    /**
     * Set the Attendence of the Unit
     *  
     * @param attendances Unit's Attendence
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