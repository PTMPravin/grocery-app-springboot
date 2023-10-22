package com.ptmptm.apibyptm.Util;

import java.util.Date;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// import com.ptmptm.apibyptm.Config.Jwtptm;
import com.ptmptm.apibyptm.Model.Register_ptm;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

    // private Jwtptm jwtptm;

    // @Autowired
    // public JwtUtils(Jwtptm jwtptm) {
    // this.jwtptm = jwtptm;
    // }

    // String ptm = jwtptm.getPtm();
    String ptm = "alptraammviilnar";
    private static long expiryDuration = 7 * 24 * 60 * 60;

    // Method For Generate Json Web Token
    public String generateJwt(Register_ptm register_ptm) {

        long milliSeconds = System.currentTimeMillis();
        long expiryTime = milliSeconds + expiryDuration * 1000;

        Date issuedAt = new Date();
        Date expiryAt = new Date(expiryTime);

        // Claims
        Claims claims = Jwts.claims()
                .setIssuer(register_ptm.getUserName())
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);

        claims.put("mobileNumber", register_ptm.getMobileNumber());
        // claims.put("userName", register_ptm.getUserName());
        claims.put("userMail", register_ptm.getUserMail());

        // Generate JWT Using Claims
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, ptm)
                .compact();

    }

    public boolean verify(String authorization)
    // throws Exception
    {

        try {

            Jwts.parser().setSigningKey(ptm).parseClaimsJws(authorization);
            return true;

        } catch (Exception e) {

            // throw e;
            // System.out.println(e);
            return false;

        }
    }
}