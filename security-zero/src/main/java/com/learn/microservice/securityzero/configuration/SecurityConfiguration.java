package com.learn.microservice.securityzero.configuration;

import com.learn.microservice.securityzero.authorization.TokenBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguration
{
  @Bean
    public TokenBuilder tokenBuilder()
  {
      return new TokenBuilder();
  }
}
