package com.ptmptm.apibyptm.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bill_detail")
public class ProductDetails {

    @Id
    @Column(name = "bill_Detail_no")
    private int bill_Detail_no;

    @Column(name = "bill_Order_detail_id")
    private int bill_Order_detail_id;

    @Column(name = "bill_product_id")
    private int bill_product_id;

    @Column(name = "bill_quantity")
    private int bill_quantity;

    @Column(name = "bill_total_amount")
    private int bill_total_amount;

    public ProductDetails() {
    }

    public ProductDetails(int bill_Detail_no, int bill_Order_detail_id, int bill_product_id, int bill_quantity,
            int bill_total_amount) {
        this.bill_Detail_no = bill_Detail_no;
        this.bill_Order_detail_id = bill_Order_detail_id;
        this.bill_product_id = bill_product_id;
        this.bill_quantity = bill_quantity;
        this.bill_total_amount = bill_total_amount;
    }

    public int getBill_Detail_no() {
        return bill_Detail_no;
    }

    public void setBill_Detail_no(int bill_Detail_no) {
        this.bill_Detail_no = bill_Detail_no;
    }

    public int getBill_Order_detail_id() {
        return bill_Order_detail_id;
    }

    public void setBill_Order_detail_id(int bill_Order_detail_id) {
        this.bill_Order_detail_id = bill_Order_detail_id;
    }

    public int getBill_product_id() {
        return bill_product_id;
    }

    public void setBill_product_id(int bill_product_id) {
        this.bill_product_id = bill_product_id;
    }

    public int getBill_quantity() {
        return bill_quantity;
    }

    public void setBill_quantity(int bill_quantity) {
        this.bill_quantity = bill_quantity;
    }

    public int getBill_total_amount() {
        return bill_total_amount;
    }

    public void setBill_total_amount(int bill_total_amount) {
        this.bill_total_amount = bill_total_amount;
    }

}
