package com.Doctor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Monthly_Details
{
    @Id
    private int record_id;
    @Temporal(TemporalType.DATE)
    private Date preg_start_date;
    @Temporal(TemporalType.DATE)
    private Date preg_due_date;
    private String sonography_details;
    private float BP;
    private float sugar;

    public Monthly_Details() {
    }

    public Monthly_Details(int record_id, Date preg_start_date, Date preg_due_date, String sonography_details, float BP, float sugar) {
        this.record_id = record_id;
        this.preg_start_date = preg_start_date;
        this.preg_due_date = preg_due_date;
        this.sonography_details = sonography_details;
        this.BP = BP;
        this.sugar = sugar;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public Date getPreg_start_date() {
        return preg_start_date;
    }

    public void setPreg_start_date(Date preg_start_date) {
        this.preg_start_date = preg_start_date;
    }

    public Date getPreg_due_date() {
        return preg_due_date;
    }

    public void setPreg_due_date(Date preg_due_date) {
        this.preg_due_date = preg_due_date;
    }

    public String getSonography_details() {
        return sonography_details;
    }

    public void setSonography_details(String sonography_details) {
        this.sonography_details = sonography_details;
    }

    public float getBP() {
        return BP;
    }

    public void setBP(float BP) {
        this.BP = BP;
    }

    public float getSugar() {
        return sugar;
    }

    public void setSugar(float sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "Monthly_Details{" +
                "record_id=" + record_id +
                ", preg_start_date=" + preg_start_date +
                ", preg_due_date=" + preg_due_date +
                ", sonography_details='" + sonography_details + '\'' +
                ", BP=" + BP +
                ", sugar=" + sugar +
                '}';
    }
}
