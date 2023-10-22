package com.ptmptm.apibyptm.Dto;

public class AddressDto {
    private String name;
    private String mobileNumber;
    private String doorNumber_Street;
    private String area;
    private String landMark;
    private String town_City;
    private String pincode;
    private String regMobileNumber;
    public AddressDto() {
    }
    public AddressDto(String name, String mobileNumber, String doorNumber_Street, String area, String landMark,
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
        return "AddressDto [name=" + name + ", mobileNumber=" + mobileNumber + ", doorNumber_Street="
                + doorNumber_Street + ", area=" + area + ", landMark=" + landMark + ", town_City=" + town_City
                + ", pincode=" + pincode + ", regMobileNumber=" + regMobileNumber + "]";
    }

}
