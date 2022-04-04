package com.Doctor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

public class Shift
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shift_id;
    private String shift_availability;

    @Temporal(value = TemporalType.DATE)
    private Date shift_date;

    @OneToOne(targetEntity = Doctor.class)
    private Doctor doctor;

    @OneToOne(targetEntity = Staff.class)
    private Staff staff;

    public Shift(){}

    public Shift(int shift_id, String shift_availability, Date shift_date, Doctor doctor, Staff staff) {
        this.shift_id = shift_id;
        this.shift_availability = shift_availability;
        this.shift_date = shift_date;
        this.doctor = doctor;
        this.staff = staff;
    }

    public int getShift_id() {
        return shift_id;
    }

    public void setShift_id(int shift_id) {
        this.shift_id = shift_id;
    }

    public String getShift_availability() {
        return shift_availability;
    }

    public void setShift_availability(String shift_availability) {
        this.shift_availability = shift_availability;
    }

    public Date getShift_date() {
        return shift_date;
    }

    public void setShift_date(Date shift_date) {
        this.shift_date = shift_date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
