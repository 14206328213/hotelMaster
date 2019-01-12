package com.fhx.service;

public interface OrderService {
    boolean payOrder(String ono);
    public abstract int findrIDby(String cID,int otype);
    public abstract String findcIDby(String rID,int otype);
}
