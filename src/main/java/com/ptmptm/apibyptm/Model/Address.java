package com.ptmptm.apibyptm.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

    @Column(name = "name")
    private String name;

    @Column(name = "mobileNumber")
    @Id
    private String mobileNumber;

    @Column(name = "doorNumber_Street")
    private String doorNumber_Street;

    @Column(name = "area")
    private String area;

    @Column(name = "landMark")

    private String landMark;

    @Column(name = "town_City")
    private String town_City;
    
    @Column(name = "pincode")
    private String pincode;

    @Column(name = "reg_mobile_number")
    private String regMobileNumber;

    public Address() {
    }

    public Address(String name, String mobileNumber, String doorNumber_Street, String area, String landMark,
            String town_City, String pincode, String regMobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.doorNumber_Street = doorNumber_Street;
        this.area = area;
        this.landMark = landMark;
        this.town_City = town_City;
        this.pincode = pincode;
        this.regMobileNumber = regMobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDoorNumber_Street() {
        return doorNumber_Street;
    }

    public void setDoorNumber_Street(String doorNumber_Street) {
        this.doorNumber_Street = doorNumber_Street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getTown_City() {
        return town_City;
    }

    public void setTown_City(String town_City) {
        this.town_City = town_City;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getRegMobileNumber() {
        return regMobileNumber;
    }

    public void setRegMobileNumber(String regMobileNumber) {
        this.regMobileNumber = regMobileNumber;
    }

    @Override
    public String toString() {
        return "Address [name=" + name + ", mobileNumber=" + mobileNumber + ", doorNumber_Street=" + doorNumber_Street
                + ", area=" + area + ", landMark=" + landMark + ", town_City=" + town_City + ", pincode=" + pincode
                + ", regMobileNumber=" + regMobileNumber + "]";
    }

}
