package com.ptmptm.apibyptm.Dto;

public class Login_ptmDto {

    private String mobileNumber;

    private String userPassword;

    public Login_ptmDto() {
    }

    public Login_ptmDto(String mobileNumber, String userPassword) {
        this.mobileNumber = mobileNumber;
        this.userPassword = userPassword;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "Login_ptmDto [mobileNumber=" + mobileNumber + ", userPassword=" + userPassword + "]";
    }

}
