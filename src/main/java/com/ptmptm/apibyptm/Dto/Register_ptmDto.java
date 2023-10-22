package com.ptmptm.apibyptm.Dto;

public class Register_ptmDto {

    private String user_name;

    private String user_mail;

    private String mobile_number;

    private String user_password;

    private String confirm_password;

    private int active_status;

    private String user_role;

    public Register_ptmDto() {
    }

    public Register_ptmDto(String user_name, String user_mail, String mobile_number, String user_password,
            String confirm_password, int active_status, String user_role) {
        this.user_name = user_name;
        this.user_mail = user_mail;
        this.mobile_number = mobile_number;
        this.user_password = user_password;
        this.confirm_password = confirm_password;
        this.active_status = active_status;
        this.user_role = user_role;
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

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public int getActive_status() {
        return active_status;
    }

    public void setActive_status(int active_status) {
        this.active_status = active_status;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    @Override
    public String toString() {
        return "Register_ptmDto [user_name=" + user_name + ", user_mail=" + user_mail + ", mobile_number="
                + mobile_number + ", user_password=" + user_password + ", confirm_password=" + confirm_password
                + ", active_status=" + active_status + ", user_role=" + user_role + "]";
    }

}
