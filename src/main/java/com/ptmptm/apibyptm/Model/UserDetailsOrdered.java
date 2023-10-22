// package com.ptmptm.apibyptm.Model;

// import jakarta.persistence.Column;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// public class UserDetailsOrdered {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name = "user_name")
//     private String userName;

//     @Column(name = "user_mail")
//     private String userMail;

//     @Column(name = "mobile_number")
//     private String mobileNumber;

//     public UserDetailsOrdered() {
//     }

//     public UserDetailsOrdered(Long id, String userName, String userMail, String mobileNumber) {
//         this.id = id;
//         this.userName = userName;
//         this.userMail = userMail;
//         this.mobileNumber = mobileNumber;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getUserName() {
//         return userName;
//     }

//     public void setUserName(String userName) {
//         this.userName = userName;
//     }

//     public String getUserMail() {
//         return userMail;
//     }

//     public void setUserMail(String userMail) {
//         this.userMail = userMail;
//     }

//     public String getMobileNumber() {
//         return mobileNumber;
//     }

//     public void setMobileNumber(String mobileNumber) {
//         this.mobileNumber = mobileNumber;
//     }

//     @Override
//     public String toString() {
//         return "UserDetailsOrdered [id=" + id + ", userName=" + userName + ", userMail=" + userMail + ", mobileNumber="
//                 + mobileNumber + "]";
//     }

// }
