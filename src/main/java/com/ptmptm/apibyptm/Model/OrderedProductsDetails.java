// package com.ptmptm.apibyptm.Model;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "ordered_Products")
// public class OrderedProductsDetails {

//     @Column(name = "productId")
//     @Id
//     private int productId;

//     @Column(name = "productName")
//     private String productName;

//     @Column(name = "productPrice")
//     private double productPrice;

//     @Column(name = "orderedProductQuantity")
//     private int orderedProductQuantity;
    
//     @ManyToOne
//     @JoinColumn(name = "order_id") // Relationship with Order entity
//     private OrderedUserDetails order;
    
// }
