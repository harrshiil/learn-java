package com.microservice.bootfilter.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExampleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        if (httpServletRequest.getHeader("Authorization") == null)
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);

        chain.doFilter(request,response);

    }
}
