package com.Doctor;

import javax.persistence.*;
import javax.print.Doc;
@Entity
public class Department
{
    @Id
    private int dept_id;
    private String dept_name;
//    @ManyToOne
//    @JoinColumn(name = "doctor_license_id")
//    private Doctor doctor;
//    @ManyToOne
//    @JoinColumn(name = "staff_id")
//    private Staff staff;

    public Department() {
    }

    public Department(int dept_id, String dept_name) {
        this.dept_id = dept_id;
        this.dept_name = dept_name;
//        this.doctor = doctor;
//        this.staff = staff;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
//
//    public Staff getStaff() {
//        return staff;
//    }
//
//    public void setStaff(Staff staff) {
//        this.staff = staff;
//    }
}
