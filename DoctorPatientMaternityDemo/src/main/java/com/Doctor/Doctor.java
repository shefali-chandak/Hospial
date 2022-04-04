package com.Doctor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Doctor {
    @Id
    private int license_id;
    private String doc_name;
    private long doc_mobile_no;
    private int doc_experience;
    private String gender;

    @OneToMany(targetEntity = Staff.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_license_id")
    private Set<Staff> staff;

    @OneToMany(targetEntity = Qualification.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_license_id")
    private List<Qualification> qualificationList;

    private int shift;
    public static final int MORNING = 1;
    public static final int EVENING = 2;
    public static final int NIGHT = 3;

    @OneToOne(targetEntity = Department.class, cascade = CascadeType.ALL)
    private Department department;


    public Doctor() {
    }

    public Doctor(int license_id, String doc_name, long doc_mobile_no, int doc_experience, String gender, Set<Staff> staff, List<Qualification> qualificationList, int shift, Department department) {
        this.license_id = license_id;
        this.doc_name = doc_name;
        this.doc_mobile_no = doc_mobile_no;
        this.doc_experience = doc_experience;
        this.gender = gender;
        this.staff = staff;
        this.qualificationList = qualificationList;
        this.shift = shift;
        this.department = department;
    }

    public int getLicense_id() {
        return license_id;
    }

    public void setLicense_id(int license_id) {
        this.license_id = license_id;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public long getDoc_mobile_no() {
        return doc_mobile_no;
    }

    public void setDoc_mobile_no(long doc_mobile_no) {
        this.doc_mobile_no = doc_mobile_no;
    }

    public int getDoc_experience() {
        return doc_experience;
    }

    public void setDoc_experience(int doc_experience) {
        this.doc_experience = doc_experience;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Staff> getStaff() {
        return staff;
    }

    public void setStaff(Set<Staff> staff) {
        this.staff = staff;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Qualification> getQualificationList() {
        return qualificationList;
    }

    public void setQualificationList(List<Qualification> qualificationList) {
        this.qualificationList = qualificationList;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "license_id=" + license_id +
                ", doc_name='" + doc_name + '\'' +
                ", doc_mobile_no=" + doc_mobile_no +
                ", doc_experience=" + doc_experience +
                ", gender='" + gender + '\'' +
                ", staff=" + staff +
                ", qualificationList=" + qualificationList +
                ", shift=" + shift +
                ", department=" + department +
                '}';
    }
}