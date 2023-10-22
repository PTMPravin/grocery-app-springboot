package com.ptmptm.apibyptm.Repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptmptm.apibyptm.Model.Register_ptm;

@Repository
public interface Register_ptmRepository extends JpaRepository<Register_ptm, String> {

    Optional<Register_ptm> findOneByMobileNumberAndUserPassword(String mobile_number, String user_password);

    Register_ptm findByMobileNumber(String mobileNumber);

}
