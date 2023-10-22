package com.ptmptm.apibyptm.PayloadResponse;

public class InitialChecking {
    String isLoggedIn;

    public InitialChecking() {
    }

    public InitialChecking(String isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public String getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(String isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

}
