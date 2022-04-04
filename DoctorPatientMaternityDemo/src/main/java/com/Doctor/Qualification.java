package com.Doctor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Qualification
{
    @Id
    private int qualifcation_id;
    private String degree;
    private int passing_year;
    private float percentage;

    public Qualification() {
    }

    public Qualification(int qualifcation_id, String degree, int passing_year, float percentage) {
        this.qualifcation_id = qualifcation_id;
        this.degree = degree;
        this.passing_year = passing_year;
        this.percentage = percentage;

    }

    public int getQualifcation_id() {
        return qualifcation_id;
    }

    public void setQualifcation_id(int qualifcation_id) {
        this.qualifcation_id = qualifcation_id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getPassing_year() {
        return passing_year;
    }

    public void setPassing_year(int passing_year) {
        this.passing_year = passing_year;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }


    @Override
    public String toString() {
        return "Qualification{" +
                "qualifcation_id=" + qualifcation_id +
                ", degree='" + degree + '\'' +
                ", passing_year=" + passing_year +
                ", percentage=" + percentage +
                '}';
    }
}
