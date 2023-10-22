package com.ptmptm.apibyptm.Services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import java.util.List;

import org.apache.catalina.User;
// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ptmptm.apibyptm.Dto.AddressDto;
import com.ptmptm.apibyptm.Dto.Check_Login_Status;
import com.ptmptm.apibyptm.Dto.EditProfile;
import com.ptmptm.apibyptm.Dto.Login_ptmDto;
import com.ptmptm.apibyptm.Dto.Register_ptmDto;
import com.ptmptm.apibyptm.Dto.ResetPassword;
import com.ptmptm.apibyptm.Dto.StatusDto;
import com.ptmptm.apibyptm.Model.Address;
import com.ptmptm.apibyptm.Model.OrderedUserDetails;
import com.ptmptm.apibyptm.Model.Product_ptm;
// import com.ptmptm.apibyptm.Model.Ordered_Products;
import com.ptmptm.apibyptm.Model.Register_ptm;
import com.ptmptm.apibyptm.PayloadResponse.InitialChecking;
import com.ptmptm.apibyptm.PayloadResponse.LoginMessage;
import com.ptmptm.apibyptm.Repositary.AddressRepositary;
import com.ptmptm.apibyptm.Repositary.OrderUserDetailsRepositary;
import com.ptmptm.apibyptm.Repositary.Product_ptmRepositary;
// import com.ptmptm.apibyptm.Repositary.OrderedProductsRepositary;
import com.ptmptm.apibyptm.Repositary.Register_ptmRepository;
import com.ptmptm.apibyptm.Util.JwtUtils;

import io.jsonwebtoken.Jwts;

@Service
public class Register_ptmService {

    @Autowired
    private Register_ptmRepository register_ptmRepository;

    @Autowired
    private Product_ptmRepositary product_ptmRepositary;

    @Autowired
    private JwtUtils jwtUtils;

    // @Autowired
    // private OrderedProductsRepositary orderedProductsRepositary;

    @Autowired
    private AddressRepositary addressRepositary;

    @Autowired
    private OrderUserDetailsRepositary orderUserDetailsRepositary;

    // @Autowired
    // private PtmProperties ptmProperties;

    // String ptmKey = ptmProperties.getPtmKey();

    public Register_ptmService(Register_ptmRepository register_ptmRepository) {
        this.register_ptmRepository = register_ptmRepository;
    }

    public ResponseEntity<String> saveData(Register_ptmDto register_ptmDto) {

        Register_ptm register_ptm = new Register_ptm(
                register_ptmDto.getUser_name(),
                register_ptmDto.getUser_mail(),
                register_ptmDto.getMobile_number(),
                register_ptmDto.getUser_password(),
                register_ptmDto.getConfirm_password(),
                register_ptmDto.getActive_status(),
                register_ptmDto.getUser_role()
                );

        System.out.println(register_ptm);

        try {
            register_ptmRepository.save(register_ptm);
            return new ResponseEntity<>("DataSavedSucessfully", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>("ErrorSavingData",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public LoginMessage loginAuthentication(Login_ptmDto login_ptmDto) {

        // String msg = "";
        Register_ptm register_ptm = register_ptmRepository.findByMobileNumber(login_ptmDto.getMobileNumber());
        
        if (register_ptm != null) {
            String userPasswordDto = login_ptmDto.getUserPassword();
            String userPassword = register_ptm.getUserPassword();
            String userRole = register_ptm.getUserRole();

            System.out.println("userPasswordDto : " + userPasswordDto);
            System.out.println("userPassword : " + userPassword);
            System.out.println("userRole : " + userRole);

            Boolean isPassCor = userPasswordDto.equals(userPassword);

            if (isPassCor) {

                Optional<Register_ptm> registerOptional = register_ptmRepository
                        .findOneByMobileNumberAndUserPassword(login_ptmDto.getMobileNumber(),
                                userPassword);

                if (registerOptional.isPresent()) {

                    String token = jwtUtils.generateJwt(register_ptm);

                    // Map<String, Object> dataToken = new HashMap<>();
                    // dataToken.put("accessToken", token);
                    System.out.println("Login Correctly");

                    return new LoginMessage(token, true,userRole);

                } else {

                    System.out.println("Login Faield False");
                    return new LoginMessage("Login Failed", false,userRole);
                }
            } else {

                System.out.println("Login Faield Password");
                return new LoginMessage("Password Not Match", false,userRole);
            }

        } else {

            System.out.println("Login Failed Mobile");
            return new LoginMessage("MobileNumber Not Exits", false,"bu");

        }
    }

    public InitialChecking checkingInitialLoginStatus(String ptmToken)
    // throws Exception
    {

        try {

            Jwts.parser().setSigningKey("alptraammviilnar").parseClaimsJws(ptmToken);
            return new InitialChecking("true");

        } catch (Exception e) {

            // return new InitialChecking("false");
            return new InitialChecking("false");

        }
    }

    // public List<Ordered_Products> saveOrderedProductsToDataBase(@RequestBody List<Ordered_Products> ordered_Products) {

    //     // Ordered_Products ordered_Products = new Ordered_Products(
    //     //         orderedProducts.getProductId(),
    //     //         orderedProducts.getProductName(),
    //     //         orderedProducts.getProductPrice(),
    //     //         orderedProducts.getProductCatagoriesId(),
    //     //         orderedProducts.getProductClassPath(),
    //     //         orderedProducts.getProductQuantity());

    //     // System.out.println(register_ptm);
    //         return orderedProductsRepositary.saveAll(ordered_Products);
    // }

    public ResponseEntity<String> saveAddressToDataBase(AddressDto addressDto) {

        Address address = new Address(
                addressDto.getName(),
                addressDto.getMobileNumber(),
                addressDto.getDoorNumber_Street(),
                addressDto.getArea(),
                addressDto.getLandMark(),
                addressDto.getTown_City(),
                addressDto.getPincode(),
                addressDto.getRegMobileNumber()
                );

        // System.out.println(register_ptm);

        try {
            addressRepositary.save(address);
            return new ResponseEntity<>("DataSavedSucessfully", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>("ErrorSavingData",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> resetPasswordGiven(ResetPassword resetPassword) {

        // Register_ptm register_ptm = new Register_ptm();
        // String msg = "";
        Register_ptm register_ptm75 = register_ptmRepository.findByMobileNumber(resetPassword.getMobileNumber());

        if (register_ptm75 != null) {

            System.out.println("Register_ptm75"+register_ptm75);

            // String register_ptm2 = register_ptm.getUserPassword();
            String newPassword = resetPassword.getNewPassword();
            String confirmNewPassword = resetPassword.getConfirmNewPassword();
            register_ptm75.setUserPassword(newPassword);
            register_ptm75.setConfirmPassword(confirmNewPassword);
            // ResetPassword resetPassword2 = resetPassword.getConfirmNewPassword();
            // System.out.println(register_ptm2);
            System.out.println("    "+newPassword);
            System.out.println("    "+confirmNewPassword);
            System.out.println("Register_ptm75"+register_ptm75);

            register_ptmRepository.save(register_ptm75);
            return new ResponseEntity<>("DataSavedSucessfully", HttpStatus.OK);
            // User user = register_ptm.getUserPassword();
        } else {

            System.out.println("Login Faield Mobile");
            return new ResponseEntity<>("Mobile Number Not Enterd", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    public ResponseEntity<String> editProfile(EditProfile editProfile) {

        // Register_ptm register_ptm = new Register_ptm();
        // String msg = "";
        Register_ptm register_ptm75 = register_ptmRepository.findByMobileNumber(editProfile.getMobileNumber());

        if (register_ptm75 != null) {

            System.out.println("Register_ptm75"+register_ptm75);

            // String register_ptm2 = register_ptm.getUserPassword();
            String newName = editProfile.getUser_name();
            String email = editProfile.getUser_mail();
            System.out.println("newName"+newName);
            System.out.println("email"+email);
            System.out.println("email"+email.isEmpty());

            if (!newName.isEmpty() && !email.isEmpty()) {
                register_ptm75.setUserName(newName);
                register_ptm75.setUserMail(email);
                System.out.println("v");
            }else if(!newName.isEmpty()){
                register_ptm75.setUserName(newName);
                System.out.println("vv");
            }else if(!email.isEmpty()){
                register_ptm75.setUserMail(email);
                System.out.println("vv");
            }

            System.out.println("Register_ptm75"+register_ptm75);

            register_ptmRepository.save(register_ptm75);
            return new ResponseEntity<>("DataSavedSucessfully", HttpStatus.OK);
            // User user = register_ptm.getUserPassword();
        } else {

            System.out.println("Login Faield Mobile");
            return new ResponseEntity<>("Mobile Number Not Enterd", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    // public void resetPasswordGiven(ResetPassword resetPassword) {

    //     // Register_ptm register_ptm = new Register_ptm();
    //     // String msg = "";
    //     Register_ptm register_ptm75 = register_ptmRepository.findByMobileNumber(resetPassword.getMobileNumber());

    //     if (register_ptm75 != null) {

    //         System.out.println("Register_ptm75"+register_ptm75);

    //         // String register_ptm2 = register_ptm.getUserPassword();
    //         String newPassword = resetPassword.getNewPassword();
    //         String confirmNewPassword = resetPassword.getConfirmNewPassword();
    //         register_ptm75.setUserPassword(newPassword);
    //         register_ptm75.setConfirmPassword(confirmNewPassword);
    //         // ResetPassword resetPassword2 = resetPassword.getConfirmNewPassword();
    //         // System.out.println(register_ptm2);
    //         System.out.println("    "+newPassword);
    //         System.out.println("    "+confirmNewPassword);
    //         System.out.println("Register_ptm75"+register_ptm75);

    //         // register_ptmRepository.save(register_ptm);
    //         // return new ResponseEntity<>("DataSavedSucessfully", HttpStatus.OK);
    //         // User user = register_ptm.getUserPassword();
    //     } else {

    //         System.out.println("Login Faield Mobile");
    //         // return new ResponseEntity<>("Mobile Number Not Enterd", HttpStatus.INTERNAL_SERVER_ERROR);

    //     }
    // }

    public Address retriveAddressFromDataBase(AddressDto addressDto) {

        String mobileNumber = addressDto.getRegMobileNumber();
        if(mobileNumber!=null){
             return addressRepositary.findByMobileNumber(mobileNumber);
        }
        else{
            return null;
        }
    }

    public OrderedUserDetails saveOrder(OrderedUserDetails orderedUserDetails) {
        System.out.println("orderedUserDetails : "+orderedUserDetails);
        return orderUserDetailsRepositary.save(orderedUserDetails);
    }

    public ResponseEntity<String> postProductDetails(Product_ptm product_ptm) {


        System.out.println("product_ptm : "+product_ptm);

        try {
            product_ptmRepositary.save(product_ptm);
            return new ResponseEntity<>("DataSavedSucessfully", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>("ErrorSavingData",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Address getAddress(String mobileNumber) {
        Address address = addressRepositary.findByMobileNumber(mobileNumber);
        System.out.println("Address : "+address);
        return address;
    }

    public ResponseEntity<String> status(StatusDto statusDto) {

        // OrderedUserDetails orderedUser = orderUserDetailsRepositary.findById(statusDto.getId());
        Optional<OrderedUserDetails> optionalUserDetails = orderUserDetailsRepositary.findById(statusDto.getId());
        OrderedUserDetails orderedUserDetails = optionalUserDetails.orElse(new OrderedUserDetails());
        // OrderedUserDetails orderedUserDetails = new OrderedUserDetails();


        System.out.println("orderedUserDetails : "+optionalUserDetails);

        int newStatus = statusDto.getStatus();
        System.out.println("newStatus : "+newStatus);
        orderedUserDetails.setStatus(newStatus);
        int newStatusn = orderedUserDetails.getStatus();
        System.out.println("newStatusn : "+newStatusn);
        System.out.println("orderedUserDetails : "+optionalUserDetails);

        orderUserDetailsRepositary.save(orderedUserDetails);
        return new ResponseEntity<>("DataSavedSucessfully", HttpStatus.OK);
    }

    // public ResponseEntity<String> status(StatusDto statusDto) {
    //     Optional<OrderedUserDetails> optionalUserDetails = orderUserDetailsRepositary.findById(statusDto.getId());
    
    //     if (optionalUserDetails.isPresent()) {
    //         OrderedUserDetails orderedUserDetails = optionalUserDetails.get();
    
    //         int newStatus = statusDto.getStatus();
    //         orderedUserDetails.setStatus(newStatus);
    //         System.out.println("orderedUserDetails : "+orderedUserDetails);
    
    //         orderUserDetailsRepositary.save(orderedUserDetails);
    
    //         return new ResponseEntity<>("DataSavedSuccessfully", HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>("Entity with ID not found", HttpStatus.NOT_FOUND);
    //     }
    // }

    public ResponseEntity<String> remove(StatusDto statusDto) {

        // OrderedUserDetails orderedUser = orderUserDetailsRepositary.findById(statusDto.getId());
        // Optional<OrderedUserDetails> optionalUserDetails = orderUserDetailsRepositary.findById(statusDto.getId());
        // OrderedUserDetails orderedUserDetails = optionalUserDetails.orElse(new OrderedUserDetails());
        // // OrderedUserDetails orderedUserDetails = new OrderedUserDetails();


        // System.out.println("orderedUserDetails : "+optionalUserDetails);

        Long newStatus = statusDto.getId();
        System.out.println("newStatus : "+newStatus);
        // orderedUserDetails.setStatus(newStatus);
        // int newStatusn = orderedUserDetails.getStatus();
        // System.out.println("newStatusn : "+newStatusn);
        // System.out.println("orderedUserDetails : "+optionalUserDetails);

        orderUserDetailsRepositary.deleteById(newStatus);
        return new ResponseEntity<>("DataSavedSucessfully", HttpStatus.OK);
        
    }
}