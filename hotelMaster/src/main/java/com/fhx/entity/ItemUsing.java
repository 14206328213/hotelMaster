package com.fhx.entity;

import java.util.Date;

public class ItemUsing extends Item {
    Date ieTime;
    int ieday;
    float iecost;

    public Date getIeTime() {
        return ieTime;
    }

    public void setIeTime(Date ieTime) {
        this.ieTime = ieTime;
    }

    public int getIeday() {
        return ieday;
    }

    public void setIeday(int ieday) {
        this.ieday = ieday;
    }

    public float getIecost() {
        return iecost;
    }

    public void setIecost(float iecost) {
        this.iecost = iecost;
    }

    @Override
    public String toString() {
        return "ItemUsing{" +
                "ieTime=" + ieTime +
                ", ieday=" + ieday +
                ", iecost=" + iecost +
                '}';
    }
}
