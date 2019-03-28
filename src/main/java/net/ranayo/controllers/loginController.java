package net.ranayo.controllers;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.ranayo.service.userService;

@Controller
public class loginController {
	@Autowired
	private userService userSv;
	
	
	@RequestMapping("/login-pg")
	public String loginPage(){
		return "/module/login/login";
	}


	@GetMapping("/users/join-pg")
	public String goJoin() {
		return "/module/login/join";
	}
	
	@RequestMapping(value = "/users/login", method = {RequestMethod.POST})
	public String Login(@RequestParam Map<String, String> map, HttpServletRequest request
            , HttpServletResponse response) throws Exception {
		if(!userSv.coLogin(map)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 정보를 확인해주세요.');</script>");
			out.flush();
			
			return "redirect:/users/login-pg";
		}
		else {
			return "redirect:/";
		}
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
	public String goLogin(HttpServletRequest request
            , HttpServletResponse response) throws Exception {
		
		userSv.ChkSession(request, response);
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
