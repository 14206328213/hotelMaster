package com.fhx.entity;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Room {
    //房间的状态 0空闲，1预定，2入住
    public static final int FREE=0;
    public static final int ORDER=1;
    public static final int USING=2;

    private int status;
    private float rcost;
    private String rname;
    private int rID;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getRcost() {
        return rcost;
    }

    public void setRcost(float rcost) {
        this.rcost = rcost;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    @Override
    public String toString() {
        return "Room{" +
                "status=" + status +
                ", rcost=" + rcost +
                ", rname='" + rname + '\'' +
                ", rID=" + rID +
                '}';
    }


}
