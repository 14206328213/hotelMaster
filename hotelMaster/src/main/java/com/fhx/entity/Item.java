package com.fhx.entity;

public class Item {
    protected String iname;
    protected int stock;
    protected String iiD;
    protected float icost;
    protected String unit;

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public int getStock() {
        return stock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getIiD() {
        return iiD;
    }

    public void setIiD(String iiD) {
        this.iiD = iiD;
    }

    public float getIcost() {
        return icost;
    }

    public void setIcost(float icost) {
        this.icost = icost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "iname='" + iname + '\'' +
                ", stock=" + stock +
                ", iiD='" + iiD + '\'' +
                ", icost=" + icost +
                '}';
    }
}
