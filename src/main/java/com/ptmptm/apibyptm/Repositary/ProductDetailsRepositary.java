package com.ptmptm.apibyptm.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import com.ptmptm.apibyptm.Model.ProductDetails;

@Repository
public interface ProductDetailsRepositary extends JpaRepository<ProductDetails, Integer> {

}
