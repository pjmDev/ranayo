package net.ranayo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.ranayo.service.userService;

@Controller
public class loginController {
	@Autowired
	private userService userSv;
	
	@GetMapping("/users/join-pg")
	public String goJoin() {
		return "/module/login/join";
	}
	
	@PostMapping("/users/join")
	public String Join(@RequestParam Map<String, String> map) {
		//String usEmail = map.get("usEmail");
		//String usNickname = map.get("usNickname");
		//String usPasswd = map.get("usPasswd");
		
		userSv.coJoin(map);
		return "redirect:/users/login-pg";
	}
	
	@GetMapping("/users/login-pg")
	public String goLogin() {
		return "/module/login/login";
	}
	
	@GetMapping("/users/findid-pg")
	public String goFindId() {
		return "/module/login/findId";
	}	
	
	@GetMapping("/users/findpwd-pg")
	public String goFindPwd() {
		return "/module/login/findPasswd";
	}
	
	
}
