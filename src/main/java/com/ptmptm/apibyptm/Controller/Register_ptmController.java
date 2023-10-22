package com.ptmptm.apibyptm.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptmptm.apibyptm.Dto.AddressDto;
import com.ptmptm.apibyptm.Dto.Check_Login_Status;
import com.ptmptm.apibyptm.Dto.EditProfile;
import com.ptmptm.apibyptm.Dto.Login_ptmDto;
// import com.ptmptm.apibyptm.Dto.OrderRequest;
import com.ptmptm.apibyptm.Dto.Register_ptmDto;
import com.ptmptm.apibyptm.Dto.ResetPassword;
import com.ptmptm.apibyptm.Dto.StatusDto;
import com.ptmptm.apibyptm.Model.Address;
// import com.ptmptm.apibyptm.Model.Ordered_Products;
import com.ptmptm.apibyptm.Model.OrderedUserDetails;
import com.ptmptm.apibyptm.Model.Product_ptm;
import com.ptmptm.apibyptm.Model.Register_ptm;
import com.ptmptm.apibyptm.PayloadResponse.InitialChecking;
import com.ptmptm.apibyptm.PayloadResponse.LoginMessage;
import com.ptmptm.apibyptm.Repositary.OrderUserDetailsRepositary;
import com.ptmptm.apibyptm.Repositary.OrderUserDetailsRepositary;
import com.ptmptm.apibyptm.Services.NewUserDetailsServices;
import com.ptmptm.apibyptm.Services.Register_ptmService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/api/register_ptm")
public class Register_ptmController {

    @Autowired
    private Register_ptmService register_ptmService;

    @Autowired
    private NewUserDetailsServices userDetailsServices;

    @Autowired
    private OrderUserDetailsRepositary orderRepositary;

    @Autowired
    private OrderUserDetailsRepositary orderUserDetailsRepositary;

    public Register_ptmController(Register_ptmService register_ptmService) {
        this.register_ptmService = register_ptmService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> sendDataToSaveData(@RequestBody Register_ptmDto register_ptmDto) {

        System.out.println(register_ptmDto);

        return register_ptmService.saveData(register_ptmDto);

    }

    @PostMapping("/login")
    public ResponseEntity<?> sendDataToLoginAuthentication(@RequestBody Login_ptmDto login_ptmDto) {
        System.out.println("login");
        System.out.println(login_ptmDto);

        LoginMessage loginMessage = register_ptmService.loginAuthentication(login_ptmDto);
        System.out.println("LoginMessage" + loginMessage);

        return ResponseEntity.ok(loginMessage);

    }

    @GetMapping("/getProductDetails")
    public List<Product_ptm> getProductDetailsController() {
        // System.out.println("YIFYFFIYFIUFIUF");
        return userDetailsServices.getProductDetails();
    }

    @PostMapping("/postProductDetails")
    public ResponseEntity<String> sendpostProductDetails(@RequestBody Product_ptm product_ptm) {

        System.out.println(product_ptm);

        return register_ptmService.postProductDetails(product_ptm);

    }

    @GetMapping("/isLoggedIn")
    public ResponseEntity<?> checkLoginStatus(
            // @RequestBody Check_Login_Status check_Login_Status,
            HttpServletRequest request) throws Exception {

        String ptmToken = request.getHeader("authorization");
        System.out.println("Hi");
        System.out.println("ptmToken : " + ptmToken);
        InitialChecking initialChecking = register_ptmService.checkingInitialLoginStatus(ptmToken);

        return ResponseEntity.ok(initialChecking);
    }

    // @PostMapping("/orderedProducts")
    // public ResponseEntity<String> sendOrderProductsToServices(@RequestBody String orderedUserDetails) {

    //     System.out.println("orderedUserDetails"+orderedUserDetails);

    //     try {
    //         // register_ptmService.saveOrderedProductsToDataBase(orderedUserDetails);
    //         return new ResponseEntity<>("DataSavedSucessfully", HttpStatus.OK);
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //         return new ResponseEntity<>("ErrorSavingData",
    //                 HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @PostMapping("/saveAddress")
    public ResponseEntity<?> sendOrderProductsToServices(@RequestBody AddressDto addressDto) {

        System.out.println(addressDto);

        return register_ptmService.saveAddressToDataBase(addressDto);
    }

    // @PostMapping("/saveOrderedProducts")
    // public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {

    //     System.out.println(orderRequest);

    //     List<Ordered_Products> orderedProducts = orderRequest.getOrdered_Products();

    //     System.out.println("orderedProducts");
    //     System.out.println(orderedProducts);
    //     System.out.println("orderedProducts");

    //     // Create a new order entity
    //     OrderedUserDetails order = new OrderedUserDetails();
    //     order.setOrderTotal(orderRequest.getOrderTotal());
    //     System.out.println(orderRequest.getOrderTotal());

    //     // Generate a unique order ID using UUID
    //     String orderId = UUID.randomUUID().toString();
    //     order.setOrderId(orderId);
    //     System.out.println(orderId);

    //     // Save the order to the database
    //     OrderedUserDetails savedOrder = orderRepositary.save(order);

    //     // Process the ordered products and associate them with the order
    //     // for (Ordered_Products orderedProduct : orderRequest.getOrdered_Products()) {
    //     //     orderedProduct.setOrder(savedOrder);
    //     //     orderedProductsRepositary.save(orderedProduct);
    //     // }

    //     if (orderedProducts != null) {
    //         System.out.println("Data Is Recived");
    //         // The list is not null, you can safely iterate over it
    //         for (Ordered_Products orderedProduct : orderRequest.getOrdered_Products()) {
    //         orderedProduct.setOrder(savedOrder);
    //         orderedProductsRepositary.save(orderedProduct);
    //     }
    //     } else {
    //         System.out.println("Data Will Be Not Recived");
    //         // Handle the case when orderedProducts is null
    //         // You can log an error message or perform any necessary actions
    //         // For example, you might return an error response to the client
    //     }

    //     System.out.println(orderRequest.getOrdered_Products());

    //     return ResponseEntity.ok("Order created successfully with ID: " + orderId);
    // }

    @PostMapping("/resetPassword")
    public ResponseEntity<?> sendDataToresetPassword(@RequestBody ResetPassword resetPassword) {

        System.out.println(resetPassword);
        System.out.println("resetPassword");

        //LoginMessage loginMessage = register_ptmService.resetPasswordGiven(resetPassword);

        return register_ptmService.resetPasswordGiven(resetPassword);
        //ResponseEntity.ok(loginMessage);

    }

    @PostMapping("/editProfile")
    public ResponseEntity<?> sendDataToeditProfile(@RequestBody EditProfile editProfile) {

        System.out.println(editProfile);
        System.out.println("editProfile");

        //LoginMessage loginMessage = register_ptmService.resetPasswordGiven(resetPassword);

        return register_ptmService.editProfile(editProfile);
        //ResponseEntity.ok(loginMessage);

    }

    @PostMapping("/orderedProducts")
    public ResponseEntity<OrderedUserDetails> createOrder(@RequestBody OrderedUserDetails orderedUserDetails) {
        System.out.println(orderedUserDetails);
        System.out.println("orderedUserDetails");
        OrderedUserDetails   savedOrder = register_ptmService.saveOrder(orderedUserDetails);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @GetMapping("/retriveAddress")
    public ResponseEntity<Address> retriveAddress(@RequestBody AddressDto addressDto){

        Address address = register_ptmService.retriveAddressFromDataBase(addressDto);

        if(address!=null){
            return new ResponseEntity<>(address, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAddress")
        public Address getAddressFromServices(HttpServletRequest request) {
            String mobileNumber = request.getHeader("mobileNumber");
            System.out.println("mobile number"+mobileNumber);
            
        return register_ptmService.getAddress(mobileNumber);
    }

    @GetMapping("/orders")
    public List<OrderedUserDetails> getAllOrders() {
        // Retrieve all orders from the database
        return orderRepositary.findAll();
    }

    @PostMapping("/status")
    public ResponseEntity<?> sendstatus(@RequestBody StatusDto statusDto) {
        System.out.println("statusDto");
        System.out.println(statusDto);

        return register_ptmService.status(statusDto);

    }

    @PostMapping("/removeId")
    public ResponseEntity<?> sendremove(@RequestBody StatusDto statusDto) {
        System.out.println("statusDto");
        System.out.println(statusDto);

        return register_ptmService.remove(statusDto);

    }

}
