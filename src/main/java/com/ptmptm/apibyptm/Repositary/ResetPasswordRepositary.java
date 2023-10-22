package com.ptmptm.apibyptm.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptmptm.apibyptm.Model.Register_ptm;

@Repository
public interface ResetPasswordRepositary extends JpaRepository<Register_ptm,String>{
    
}
