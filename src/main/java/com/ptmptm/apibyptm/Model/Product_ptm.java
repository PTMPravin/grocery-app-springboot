package com.ptmptm.apibyptm.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_ptm")
public class Product_ptm {

    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "product_catagories_id")
    private int productCatagoriesId;

    @Column(name = "product_path")
    private String productClassPath;

    @Column(name = "product_quantity")
    private int productQuantity;

    public Product_ptm() {
    }

    public Product_ptm(int productId, String productName, double productPrice, int productCatagoriesId,
            String productClassPath, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCatagoriesId = productCatagoriesId;
        this.productClassPath = productClassPath;
        this.productQuantity = productQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductCatagoriesId() {
        return productCatagoriesId;
    }

    public void setProductCatagoriesId(int productCatagoriesId) {
        this.productCatagoriesId = productCatagoriesId;
    }

    public String getProductClassPath() {
        return productClassPath;
    }

    public void setProductClassPath(String productClassPath) {
        this.productClassPath = productClassPath;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "Product_ptm [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
                + ", productCatagoriesId=" + productCatagoriesId + ", productClassPath=" + productClassPath
                + ", productQuantity=" + productQuantity + "]";
    }

}
