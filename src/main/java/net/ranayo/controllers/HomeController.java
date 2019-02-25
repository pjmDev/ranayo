package net.ranayo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String goHome() {
		return "index";
	}
	
	public String test(String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}

	@GetMapping("/content/about")
	public String about() {
		return "contents/about";
	}
	
}

