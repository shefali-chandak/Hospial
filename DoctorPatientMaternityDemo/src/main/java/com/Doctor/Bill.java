package com.Doctor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bill
{
    @Id
    private int billNo;
    private float doc_charges;

    private String  roomNo;
    private int roomType;

    public static final int SpecialRoom = 1;
    public static final int SemiRoom = 2;
    public static final int GeneralWard = 3;

    private int days_room_occupied;
    private float room_charges;

    public Bill() {
    }

    public Bill(int billNo, float doc_charges, String roomNo, int roomType, int days_room_occupied, float room_charges) {
        this.billNo = billNo;
        this.doc_charges = doc_charges;
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.days_room_occupied = days_room_occupied;
        this.room_charges = room_charges;
    }

    public int getBillNo() {
        return billNo;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public float getDoc_charges() {
        return doc_charges;
    }

    public void setDoc_charges(float doc_charges) {
        this.doc_charges = doc_charges;
    }

    public String  getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String  roomNo) {
        this.roomNo = roomNo;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public int getDays_room_occupied() {
        return days_room_occupied;
    }

    public void setDays_room_occupied(int days_room_occupied) {
        this.days_room_occupied = days_room_occupied;
    }

    public float getRoom_charges() {
        return room_charges;
    }

    public void setRoom_charges(float room_charges) {
        this.room_charges = room_charges;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billNo=" + billNo +
                ", doc_charges=" + doc_charges +
                ", roomNo=" + roomNo +
                ", roomType=" + roomType +
                ", days_room_occupied=" + days_room_occupied +
                ", room_charges=" + room_charges +
                '}';
    }
}
