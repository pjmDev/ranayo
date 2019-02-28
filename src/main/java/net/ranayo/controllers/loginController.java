package net.ranayo.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public String Login(@RequestParam Map<String, String> map) {
		if(!userSv.coLogin(map)) {
			return "/users/login-pg";
		}
		return "redirect:/";
	}
	@RequestMapping(value = "/users/join", method = RequestMethod.POST)
	public String Join(@RequestParam Map<String, String> map) {	
		userSv.coJoin(map);
		return "redirect:/users/login-pg";
	}

	@GetMapping("/users/logout")
	public String Logout() {
		userSv.coLogout();
		return "redirect:/";
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
