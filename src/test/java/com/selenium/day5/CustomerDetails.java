package com.selenium.day5;

public class CustomerDetails {
    private String name;
    private String country;
    private String rep;
    private String joinDate;
    private String status;

    public CustomerDetails(String name, String country, String rep, String joinDate, String status) {
        this.name = name;
        this.country = country;
        this.rep = rep;
        this.joinDate = joinDate;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", rep='" + rep + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
