package net.ranayo.service;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ranayo.config.HashUtil;
import net.ranayo.model.user;
import net.ranayo.repository.userRepository;

@Service
public class userService {

	@Autowired
	private userRepository userRe;
	@Autowired
	private HttpSession session;
	
	@Transactional
	public void coJoin(Map<String, String> map) {
		try {
			
			user user = new user();
			user.setUsEmail(map.get("usEmail"));
			user.setUsNickname(map.get("usNickname"));
			
			String password = HashUtil.sha256(map.get("usPasswd"));
			
			user.setUsPasswd(password);
			user.setUsJoinip("usJoinip");
			user.setUsState(map.get("usState"));
			user.setUsUpip("usUpip");
			user.setUsAuth(70);
			
			System.out.println("cojoin");
			userRe.save(user);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	public boolean coLogin(Map<String, String> map) {
		user user = new user();
		String password = HashUtil.sha256(map.get("usPasswd"));
		user = userRe.findByusEmail(map.get("usEmail"));
		if(user == null) {
			return false;
		}
		else if(!user.getUsPasswd().equals(password)) {
			return false;
		}
		else {
			session.setAttribute("userState", user);
			return true;
		}
	}
	
	public void coLogout() {
		session.removeAttribute("userState");
		System.out.println("삭제완료");
	}
	
	public void ChkSession(HttpServletRequest request
            , HttpServletResponse response) throws Exception {
		if(session.getAttribute("usEmail") != null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 로그인 된 상태입니다.'); history.go(-1);</script>");
			out.flush();
		}
	}

}
