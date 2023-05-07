package com.example.devoxx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class CustomBasicAuthenticationFailure implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authEx) throws IOException, ServletException {
		//response.sendRedirect("http://localhost:8080/logout");
		 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        PrintWriter writer = response.getWriter();
	        writer.println("HTTP Status 200 - " + authEx.getMessage());
		
	}

}
