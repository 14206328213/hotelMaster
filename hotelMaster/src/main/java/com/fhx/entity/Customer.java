package com.fhx.entity;

public class Customer extends User{
    private String cID;
    private String cname;
    private String tel;

    public void setUser(User user){
        this.setRole(user.getRole());
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cID='" + cID + '\'' +
                ", cname='" + cname + '\'' +
                ", tel='" + tel + '\'' +
                ", role=" + role +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
