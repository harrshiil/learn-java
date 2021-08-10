package com.microservice.bootfilter.configuration;


import com.microservice.bootfilter.filter.ExampleFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicConfiguration {

    /*@Bean
    public FilterRegistrationBean<ExampleFilter> filterFilterRegistrationBean()
    {
        FilterRegistrationBean<ExampleFilter> filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new ExampleFilter());
        filterRegistrationBean.addUrlPatterns("/security/**");
        return filterRegistrationBean;
    }*/
}
