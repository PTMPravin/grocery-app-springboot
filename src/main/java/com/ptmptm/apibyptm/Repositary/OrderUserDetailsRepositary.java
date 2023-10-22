package com.ptmptm.apibyptm.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptmptm.apibyptm.Model.OrderedUserDetails;

@Repository
public interface OrderUserDetailsRepositary extends JpaRepository<OrderedUserDetails,Long>{ 
   
}
