package com.ptmptm.apibyptm.Dto;

public class ResetPassword {

    private String mobileNumber;

    private String newPassword;

    private String confirmNewPassword;

    public ResetPassword() {
    }

    public ResetPassword(String mobileNumber, String newPassword, String confirmNewPassword) {
        this.mobileNumber = mobileNumber;
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    @Override
    public String toString() {
        return "ResetPassword [mobileNumber=" + mobileNumber + ", newPassword=" + newPassword + ", confirmNewPassword="
                + confirmNewPassword + "]";
    }
    
}
