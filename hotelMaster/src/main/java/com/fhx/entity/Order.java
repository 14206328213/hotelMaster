package com.fhx.entity;

import java.util.Date;

public class Order {
    int oNo;
    String cID;
    String rID;
    int Otype;
    Date Otime;
    int day;
    //总价
    float total;
    float bargin;
    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
    }

    public int getOtype() {
        return Otype;
    }

    public void setOtype(int otype) {
        Otype = otype;
    }

    public Date getOtime() {
        return Otime;
    }

    public void setOtime(Date otime) {
        Otime = otime;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getBargin() {
        return bargin;
    }

    public void setBargin(float bargin) {
        this.bargin = bargin;
    }

    public int getoNo() {
        return oNo;
    }

    public void setoNo(int oNo) {
        this.oNo = oNo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oNo=" + oNo +
                ", cID='" + cID + '\'' +
                ", rID='" + rID + '\'' +
                ", Otype=" + Otype +
                ", Otime=" + Otime +
                ", day=" + day +
                ", total=" + total +
                ", bargin=" + bargin +
                '}';
    }
}
