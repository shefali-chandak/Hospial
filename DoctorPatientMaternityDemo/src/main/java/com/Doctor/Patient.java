package com.Doctor;

import javax.persistence.*;
import javax.print.Doc;
import java.util.Date;
import java.util.Set;

@Entity
public class Patient{
    @Id
    private int patient_id;
    private String patient_name;
    private long patient_mobile_no;
    private long patient_emergency_no;
    private String patient_blood_grp;

    /*@Temporal(value = TemporalType.DATE)
    private Date preg_start_date;
    @Temporal(value = TemporalType.DATE)
    private Date preg_due_date;*/

    private String allergies;

    @OneToMany(targetEntity = Doctor.class , cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Set<Doctor> doctor;

    public Patient(){}

    public Patient(int patient_id, String patient_name, long patient_mobile_no, long patient_emergency_no, String patient_blood_grp, String allergies, Set<Doctor> doctor) {
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.patient_mobile_no = patient_mobile_no;
        this.patient_emergency_no = patient_emergency_no;
        this.patient_blood_grp = patient_blood_grp;
//        this.preg_start_date = preg_start_date;
//        this.preg_due_date = preg_due_date;
        this.allergies = allergies;
        this.doctor = doctor;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public long getPatient_mobile_no() {
        return patient_mobile_no;
    }

    public void setPatient_mobile_no(long patient_mobile_no) {
        this.patient_mobile_no = patient_mobile_no;
    }

    public long getPatient_emergency_no() {
        return patient_emergency_no;
    }

    public void setPatient_emergency_no(long patient_emergency_no) {
        this.patient_emergency_no = patient_emergency_no;
    }

    public String getPatient_blood_grp() {
        return patient_blood_grp;
    }

    public void setPatient_blood_grp(String patient_blood_grp) {
        this.patient_blood_grp = patient_blood_grp;
    }

//    public Date getPreg_start_date() {
//        return preg_start_date;
//    }
//
//    public void setPreg_start_date(Date preg_start_date) {
//        this.preg_start_date = preg_start_date;
//    }
//
//    public Date getPreg_due_date() {
//        return preg_due_date;
//    }
//
//    public void setPreg_due_date(Date preg_due_date) {
//        this.preg_due_date = preg_due_date;
//    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Set<Doctor> getDoctor() {
        return doctor;
    }

    public void setDoctor(Set<Doctor> doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + patient_id +
                ", patient_name='" + patient_name + '\'' +
                ", patient_mobile_no=" + patient_mobile_no +
                ", patient_emergency_no=" + patient_emergency_no +
                ", patient_blood_grp='" + patient_blood_grp + '\'' +
                ", allergies='" + allergies + '\'' +
                ", doctor=" + doctor +
                '}';
    }
}
