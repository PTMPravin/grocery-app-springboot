package com.ptmptm.apibyptm.Model;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_role")
public class UserDetails {

    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    @Column(name = "User_Role_id")
    private int user_Role_id;

    @Column(name = "User_Role")
    private String user_Role;

    @Column(name = "User_Role_short")
    private String user_Role_short;

    // Constructor
    public UserDetails() {
        // Empty
    }

    public UserDetails(int user_Role_id, String user_Role, String user_Role_short) {
        this.user_Role_id = user_Role_id;
        this.user_Role = user_Role;
        this.user_Role_short = user_Role_short;
    }

    public int getUser_Role_id() {
        return user_Role_id;
    }

    public void setUser_Role_id(int user_Role_id) {
        this.user_Role_id = user_Role_id;
    }

    public String getUser_Role() {
        return user_Role;
    }

    public void setUser_Role(String user_Role) {
        this.user_Role = user_Role;
    }

    public String getUser_Role_short() {
        return user_Role_short;
    }

    public void setUser_Role_short(String user_Role_short) {
        this.user_Role_short = user_Role_short;
    }

}
