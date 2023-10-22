package com.ptmptm.apibyptm.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

// import com.ptmptm.apibyptm.Model.Ordered_Products;
import com.ptmptm.apibyptm.Model.ProductDetails;
import com.ptmptm.apibyptm.Model.Product_ptm;
import com.ptmptm.apibyptm.Model.Register_ptm;
import com.ptmptm.apibyptm.Model.UserDetails;
import com.ptmptm.apibyptm.Model.newRegister;

import org.springframework.stereotype.Service;

import com.ptmptm.apibyptm.Repositary.NewRegisterRepositorty;
// import com.ptmptm.apibyptm.Repositary.OrderedProductsRepositary;
import com.ptmptm.apibyptm.Repositary.ProductDetailsRepositary;
import com.ptmptm.apibyptm.Repositary.Product_ptmRepositary;
import com.ptmptm.apibyptm.Repositary.Register_ptmRepository;
import com.ptmptm.apibyptm.Repositary.UserDetailsRepositary;

@Service
public class NewUserDetailsServices {

    @Autowired
    private UserDetailsRepositary userDetailsRepositary;

    @Autowired
    private ProductDetailsRepositary productDetailsRepositary;

    @Autowired
    private NewRegisterRepositorty newRegisterRepositorty;

    @Autowired
    private Register_ptmRepository register_ptmRepository;

    @Autowired
    private Product_ptmRepositary product_ptmRepositary;

    // @Autowired
    // private OrderedProductsRepositary orderedProductsRepositary;

    public List<UserDetails> getAllDetails() {
        return userDetailsRepositary.findAll();
    }

    public List<ProductDetails> getBillDetails() {
        return productDetailsRepositary.findAll();
    }

    public UserDetails createUser(UserDetails userDetails) {
        return this.userDetailsRepositary.save(userDetails);
    }

    public List<newRegister> getAllNewDetails() {
        return newRegisterRepositorty.findAll();
    }

    public newRegister createNewRegister(newRegister newreg) {
        return this.newRegisterRepositorty.save(newreg);
    }

    public List<Register_ptm> getRegister_ptm() {
        return register_ptmRepository.findAll();
    }

    public Register_ptm createRegister_ptm(Register_ptm register_ptm) {
        return this.register_ptmRepository.save(register_ptm);
    }

    public List<Product_ptm> getProductDetails() {
        return product_ptmRepositary.findAll();
    }

    // public List<Ordered_Products> getOrderedProductDetails() {
    //     return orderedProductsRepositary.findAll();
    // }
}
