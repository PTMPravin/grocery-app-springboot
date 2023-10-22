package com.ptmptm.apibyptm.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.ptmptm.apibyptm.Model.Ordered_Products;
import com.ptmptm.apibyptm.Model.OrderedUserDetails;
import com.ptmptm.apibyptm.Model.ProductDetails;
import com.ptmptm.apibyptm.Model.Product_ptm;
import com.ptmptm.apibyptm.Model.Register_ptm;
import com.ptmptm.apibyptm.Model.UserDetails;
import com.ptmptm.apibyptm.Model.newRegister;
import com.ptmptm.apibyptm.Repositary.OrderUserDetailsRepositary;
import com.ptmptm.apibyptm.Services.NewUserDetailsServices;
import com.ptmptm.apibyptm.Util.JwtUtils;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

@RestController
@RequestMapping("/")
public class UserDetailsController {

    @Autowired
    private NewUserDetailsServices userDetailsServices;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/getUserDetails")
    public List<UserDetails> getAllDetailsController() {
        return userDetailsServices.getAllDetails();
    }

    @GetMapping("/getBillDetails")
    public List<ProductDetails> getBillDetailsController() {
        return userDetailsServices.getBillDetails();
    }

    @PostMapping("/postUser")
    public UserDetails saveDetailsuser(@RequestBody UserDetails userDetails) {
        return this.userDetailsServices.createUser(userDetails);
    }

    @GetMapping("/getNewRegisterDetails")
    public List<newRegister> getNewRegisterDetailsController() {
        return userDetailsServices.getAllNewDetails();
    }

    @PostMapping("/postNewRegister")
    public newRegister saveNewDetailsuser(@RequestBody newRegister newreg) {
        return this.userDetailsServices.createNewRegister(newreg);
    }

    @GetMapping("/getRegister_ptmDetails")
    public List<Register_ptm> getRegister_ptmController() {

        // (@RequestHeader(value = "authorization", defaultValue = "") String auth)
        // throws Exception

        // String authorization =
        // "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJwdG0iLCJpYXQiOjE2OTA5NzQyNTMsImV4cCI6MTY5MDk3Nzg1M30.etrZ5BZ7BXmLIlh8CwOr7OeKL_lLuULmQ9YyL4JHCNUT03389uHdCXS8ZCyxeuhLdzSobfOC7VbacTdN3QRWKA";
        // jwtUtils.verify(auth);
        return userDetailsServices.getRegister_ptm();
    }

    @PostMapping("/postRegister_ptm")
    public Register_ptm sendDataTocreateRegister_ptm(@RequestBody Register_ptm register_ptm) {
        return this.userDetailsServices.createRegister_ptm(register_ptm);
    }

    @GetMapping("/getProductDetails")
        public List<Product_ptm> getProductDetailsController() {
        return userDetailsServices.getProductDetails();
    }

    // @GetMapping("/getOrderedProductDetails")
    // public List<Ordered_Products> getProductDetailsController() {
    // return userDetailsServices.getOrderedProductDetails();
    // }

}
