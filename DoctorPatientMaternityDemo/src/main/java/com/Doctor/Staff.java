package com.Doctor;

import javax.persistence.*;
import java.util.List;

@Entity
public class Staff {
    @Id
    private int staff_id;
    private String staff_name;
    private int staff_experience;
    private long staff_mobile_no;
    private String gender;

    @OneToOne(targetEntity = Department.class,cascade = CascadeType.ALL)
    private Department department;

    private int shift;
    public static final int MORNING = 1;
    public static final int EVENING = 2;
    public static final int NIGHT = 3;

    @OneToMany(targetEntity = Qualification.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id")
    private List<Qualification> qualificationList;

    public Staff(){}

    public Staff(int staff_id, String staff_name, int staff_experience, long staff_mobile_no, String gender, Department department, int shift, List<Qualification> qualificationList) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.staff_experience = staff_experience;
        this.staff_mobile_no = staff_mobile_no;
        this.gender = gender;
        this.department = department;
        this.shift = shift;
        this.qualificationList = qualificationList;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public int getStaff_experience() {
        return staff_experience;
    }

    public void setStaff_experience(int staff_experience) {
        this.staff_experience = staff_experience;
    }

    public long getStaff_mobile_no() {
        return staff_mobile_no;
    }

    public void setStaff_mobile_no(long staff_mobile_no) {
        this.staff_mobile_no = staff_mobile_no;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public List<Qualification> getQualificationList() {
        return qualificationList;
    }

    public void setQualificationList(List<Qualification> qualificationList) {
        this.qualificationList = qualificationList;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staff_id=" + staff_id +
                ",\nstaff_name='" + staff_name + '\'' +
                ",\nstaff_experience=" + staff_experience +
                ",\nstaff_mobile_no=" + staff_mobile_no +
                ",\ndepartment=" + department +
                ",\nshift=" + shift +
                ",\nqualificationList=" + qualificationList +
                '}';
    }
}
