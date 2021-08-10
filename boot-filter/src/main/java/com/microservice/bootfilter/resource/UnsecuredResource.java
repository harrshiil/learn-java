package com.microservice.bootfilter.resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unsecured")
public class UnsecuredResource
{
    @GetMapping("/greet")
    public String greet()
    {
        return "Unsecured Hello";
    }
}
