package com.Doctor;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Doctor {
    @Id
    private int license_id;
    private String doc_name;
    private long doc_mobile_no;
    private int doc_experience;

    @OneToMany(targetEntity = Staff.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_license_id")
    private Set<Staff> staff;

    private int shift;
    public static final int MORNING = 1;
    public static final int EVENING = 2;
    public static final int NIGHT = 3;

    /*
    @JoinColumn(name = "doc_license_id")
    @ManyToOne
    @JoinColumn(name = "dept_id")
    */

    @OneToOne(targetEntity = Department.class, cascade = CascadeType.ALL)
    private Department department;

    public Doctor() {
    }

    public Doctor(int license_id, String doc_name, long doc_mobile_no, int doc_experience, Set<Staff> staff, int shift, Department department) {
        this.license_id = license_id;
        this.doc_name = doc_name;
        this.doc_mobile_no = doc_mobile_no;
        this.doc_experience = doc_experience;
        this.staff = staff;
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
}