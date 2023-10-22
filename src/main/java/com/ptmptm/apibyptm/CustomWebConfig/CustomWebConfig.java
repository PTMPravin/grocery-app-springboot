package com.ptmptm.apibyptm.CustomWebConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.ptmptm.apibyptm.Config.JwtInterceptor;

@Configuration
public class CustomWebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(jwtInterceptor);

        // // TODO Auto-generated method stub
        // super.addInterceptors(registry);
    }
}
