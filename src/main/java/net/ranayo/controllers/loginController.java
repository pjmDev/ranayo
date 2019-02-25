package net.ranayo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class loginController {
	
	@GetMapping("/join-pg")
	public String goJoin() {
		return "/module/login/join";
	}
	
	@GetMapping("/login-pg")
	public String goLogin() {
		return "/module/login/login";
	}
	
	@GetMapping("/findid-pg")
	public String goFindId() {
		return "/module/login/findId";
	}	
	
	@GetMapping("/findpwd-pg")
	public String goFindPwd() {
		return "/module/login/findPasswd";
	}
	
	
}
