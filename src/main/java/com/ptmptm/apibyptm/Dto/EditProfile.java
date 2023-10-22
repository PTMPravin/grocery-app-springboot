package com.ptmptm.apibyptm.Dto;

public class EditProfile {
    private String user_name;

    private String user_mail;

    private String mobileNumber;

    public EditProfile() {
    }

    public EditProfile(String user_name, String user_mail, String mobileNumber) {
        this.user_name = user_name;
        this.user_mail = user_mail;
        this.mobileNumber = mobileNumber;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "EditProfile [user_name=" + user_name + ", user_mail=" + user_mail + ", mobileNumber=" + mobileNumber
                + "]";
    }
    
}
