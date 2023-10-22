package com.ptmptm.apibyptm.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

import com.ptmptm.apibyptm.Util.JwtUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor extends WebRequestHandlerInterceptorAdapter {

    public JwtInterceptor(WebRequestInterceptor requestInterceptor) {

        super(requestInterceptor);
        // TODO Auto-generated constructor stub

    }

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String ptmToken = request.getHeader("authorization");

        System.out.println(request.getRequestURI());
        System.out.println("Pre Handle");
        System.out.println(ptmToken);

        if (!(request.getRequestURI().contains("api/register_ptm/register")
                || request.getRequestURI().contains("api/register_ptm/login"))) {
            if (jwtUtils.verify(ptmToken)) {
                System.out.println("Verified");
                return super.preHandle(request, response, handler);
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // HTTP 400
                // response.setStatus(HttpServletResponse.SC_OK); // HTTP 200
                response.getWriter().write("{\"isLoggedIn\":\"false\"}");
                return false; // Stop further processing
            }
        } else {
            // TODO Auto-generated method stub
            return super.preHandle(request, response, handler);
        }

    }

}
