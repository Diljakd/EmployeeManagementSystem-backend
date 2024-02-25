package com.springbootjava;

import org.springframework.web.bind.annotation.GetMapping;
//Printing "Welcome All"
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WelcomeController {
	@GetMapping("/welcome")
public String welcome() {
	return "welcome All";
	
}
}
