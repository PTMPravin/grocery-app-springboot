package com.ptmptm.apibyptm.Dto;

public class Check_Login_Status {
    
    String isLoggedInStatus;

    public Check_Login_Status() {
    }

    public Check_Login_Status(String isLoggedInStatus) {
        this.isLoggedInStatus = isLoggedInStatus;
    }

    public String getIsLoggedInStatus() {
        return isLoggedInStatus;
    }

    public void setIsLoggedInStatus(String isLoggedInStatus) {
        this.isLoggedInStatus = isLoggedInStatus;
    }

}
