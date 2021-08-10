package com.learn.microservice.securityzero.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletResponse httpServletResponse=(HttpServletResponse)response;
        HttpServletRequest httpServletRequest=(HttpServletRequest)request;

        String authHeader=httpServletRequest.getHeader("Authorization");
        if ( authHeader!=null)
        {
            if (!authHeader.startsWith("Bearer"))
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"No bearer token available");
            else
            {
                //String token = authHeader.
            }
        }
        else
        {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Authorization header not available");
        }

        chain.doFilter(request,response);
    }
}
