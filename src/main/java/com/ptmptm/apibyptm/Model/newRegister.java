package com.ptmptm.apibyptm.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "newRegister")
public class newRegister {

    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    public newRegister() {
    }

    public newRegister(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
