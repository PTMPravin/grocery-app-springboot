package com.ptmptm.apibyptm.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptmptm.apibyptm.Model.Product_ptm;

@Repository
public interface Product_ptmRepositary extends JpaRepository<Product_ptm, Integer> {

}
