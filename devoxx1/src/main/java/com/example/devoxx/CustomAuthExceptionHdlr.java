package com.example.devoxx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthExceptionHdlr implements AuthenticationFailureHandler   {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authEx) throws IOException, ServletException {
		//response.sendRedirect("http://localhost:8080/common");
		 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        PrintWriter writer = response.getWriter();
	        writer.println("Hey User , could you please kindly validate your credentials and login back to service- " + authEx.getMessage());
		
	}

}
