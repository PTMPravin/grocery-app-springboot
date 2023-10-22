package com.ptmptm.apibyptm.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptmptm.apibyptm.Model.Address;

@Repository
public interface AddressRepositary extends JpaRepository<Address, String> {
    Address findByMobileNumber(String mobileNumber);
}
