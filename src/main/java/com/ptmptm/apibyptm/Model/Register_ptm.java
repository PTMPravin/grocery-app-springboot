package com.ptmptm.apibyptm.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "register_ptm")
public class Register_ptm {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_mail")
    private String userMail;

    @Column(name = "mobile_number")
    @Id
    private String mobileNumber;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "confirm_password")
    private String confirmPassword;

    @Column(name = "active_status")
    private int activeStatus;

    @Column(name = "user_role")
    private String userRole;

    public Register_ptm() {
    }

    public Register_ptm(String userName, String userMail, String mobileNumber, String userPassword,
            String confirmPassword, int activeStatus, String userRole) {
        this.userName = userName;
        this.userMail = userMail;
        this.mobileNumber = mobileNumber;
        this.userPassword = userPassword;
        this.confirmPassword = confirmPassword;
        this.activeStatus = activeStatus;
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "Register_ptm [userName=" + userName + ", userMail=" + userMail + ", mobileNumber=" + mobileNumber
                + ", userPassword=" + userPassword + ", confirmPassword=" + confirmPassword + ", activeStatus="
                + activeStatus + ", userRole=" + userRole + "]";
    }

}
