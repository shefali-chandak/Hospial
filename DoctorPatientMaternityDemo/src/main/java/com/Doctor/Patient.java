package com.Doctor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Patient{
    @Id
    private int patient_id;
    private String patient_name;
    private long patient_mobile_no;
    private long patient_emergency_no;
    private String patient_blood_grp;

    private String allergies;

    @OneToMany(targetEntity = Doctor.class , cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Set<Doctor> doctor;

    @OneToMany (targetEntity = Monthly_Details.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private List<Monthly_Details> monthly_details;

    @OneToMany (targetEntity = Bill.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private List<Bill> bills;

    public Patient(){}

    public Patient(int patient_id, String patient_name, long patient_mobile_no, long patient_emergency_no, String patient_blood_grp, String allergies, Set<Doctor> doctor, List<Monthly_Details> monthly_details, List<Bill> bills) {
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.patient_mobile_no = patient_mobile_no;
        this.patient_emergency_no = patient_emergency_no;
        this.patient_blood_grp = patient_blood_grp;
        this.allergies = allergies;
        this.doctor = doctor;
        this.monthly_details = monthly_details;
        this.bills = bills;
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

    public List<Monthly_Details> getMonthly_details() {
        return monthly_details;
    }

    public void setMonthly_details(List<Monthly_Details> monthly_details) {
        this.monthly_details = monthly_details;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
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
                ", monthly_details=" + monthly_details +
                ", bills=" + bills +
                '}';
    }
}
