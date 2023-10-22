package com.ptmptm.apibyptm.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptmptm.apibyptm.Model.UserDetails;

@Repository
public interface UserDetailsRepositary extends JpaRepository<UserDetails, Integer> {

}

// spring.datasource.password=
// spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver