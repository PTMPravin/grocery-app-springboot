package com.ptmptm.apibyptm.PayloadResponse;

public class LoginMessage {

    String message;
    Boolean status;
    String userRole;

    public LoginMessage(String message, Boolean status, String userRole) {
        this.message = message;
        this.status = status;
        this.userRole = userRole;
    }
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    

}
