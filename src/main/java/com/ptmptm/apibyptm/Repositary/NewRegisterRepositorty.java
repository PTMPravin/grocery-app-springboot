package com.ptmptm.apibyptm.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptmptm.apibyptm.Model.newRegister;

@Repository
public interface NewRegisterRepositorty extends JpaRepository<newRegister, String> {

}
