package com.example.devoxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	
	@Autowired
	public AuthenticationSuccessHandler  customAuthSuccessHandle1r;
	
	@Autowired
	public AccessDeniedHandler customAccessDeniedException;
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()/*
								 * .antMatchers("/").permitAll() .and().authorizeRequests()
								 */.antMatchers("/api/items").hasRole("freeBird")
								 .antMatchers("/common").hasRole("/USER").and()
		 // .httpBasic().authenticationEntryPoint(authenticationEntryPoint());
		 
        .formLogin().failureHandler(authenticationFailureHandler()).
        successHandler(customAuthSuccessHandle1r).and().exceptionHandling()
        .accessDeniedHandler(customAccessDeniedException);
		
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {                
            auth.inMemoryAuthentication()
            .withUser("user").password("{noop}mypassword").roles("USER").and()
            .withUser("baby").password("{noop}lookingFora...").roles("freeBird");
          
    }
	
	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new CustomAuthExceptionHdlr();
		
	}
	
	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new CustomBasicAuthenticationFailure();
		
	}
	
}

