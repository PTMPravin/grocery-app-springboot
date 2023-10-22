package com.ptmptm.apibyptm.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_user_details")
public class OrderedUserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String orderKey;

    @Column(columnDefinition = "TEXT")
    private String userDetails;

    @Column(name = "total")
    private Double total;

    @Column(name = "status")
    private int status;

    public OrderedUserDetails() {
    }

    public OrderedUserDetails(Long id, String orderKey, String userDetails, Double total, int status) {
        this.id = id;
        this.orderKey = orderKey;
        this.userDetails = userDetails;
        this.total = total;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public String getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(String userDetails) {
        this.userDetails = userDetails;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderedUserDetails [id=" + id + ", orderKey=" + orderKey + ", userDetails=" + userDetails + ", total="
                + total + ", status=" + status + "]";
    }
    
}
