package com.microservice.bootfilter.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
public class SecuredResource
{
    @GetMapping("/greet")
    public String greet()
    {
        return "Secured Hello";
    }
}
