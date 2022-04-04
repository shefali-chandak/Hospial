package com.Doctor;

import javax.persistence.*;

@Entity
public class Staff {
    @Id
    private int staff_id;
    private String staff_name;
    private int staff_experience;
    private long staff_mobile_no;
    @OneToOne(targetEntity = Department.class,cascade = CascadeType.ALL)
   // @JoinColumn(name = "staff_id")
    /*@ManyToOne
    @JoinColumn(name = "dept_id")*/
    private Department department;
//    @OneToOne(targetEntity = Shift.class,cascade = CascadeType.ALL)
//    private Shift shift;

    public Staff(){}

    public Staff(int staff_id, String staff_name, int staff_experience, long staff_mobile_no, Department department) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.staff_experience = staff_experience;
        this.staff_mobile_no = staff_mobile_no;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
