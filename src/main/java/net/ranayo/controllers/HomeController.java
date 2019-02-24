package net.ranayo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String goHome() {
		return "index";
	}
	
	@GetMapping("/test")
	public String test() {
		System.out.println("in connect");
		return "tests";
	}
	
	
	
}

