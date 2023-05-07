package com.example.devoxx;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class WebController {
	
	@GetMapping("/")
	 public LoginDTo authPage(@RequestParam LoginDTo loginDTo) {
		return loginDTo;
		
		  
	 }
	@PreAuthorize("hasRole('ROLE_freeBird')")
	@GetMapping("/api/items")
	public String publicPage() {
		return "I am a public page open to all";
	}
	@GetMapping("/private")
	public String privatePage() {
		return "I am a private  page need  some authenitcation to access me";
	}
	@GetMapping("/common")
	public ResponseEntity<String> commonPage() {
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("I am not  common  page need some authenitcation to access me");
	}
	@GetMapping("/error")
	public ResponseEntity<String> errorPage() {
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please validate your credentials!!....");
		
	}
	
}
