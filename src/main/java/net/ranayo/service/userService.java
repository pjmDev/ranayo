package net.ranayo.service;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			user.setUsPasswd(map.get("usPasswd"));
			user.setUsJoinip("usJoinip");
			user.setUsState(map.get("usState"));
			user.setUsUpip("usUpip");
			
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
		user = userRe.findByusEmail(map.get("usEmail"));
		if(user == null) {
			return false;
		}
		if(!map.get("usPasswd").equals(user.getUsPasswd())) {
			return false;
		}
		
		session.setAttribute("userState", user);
		return true;
	}
	
	public void coLogout() {
		session.removeAttribute("userState");
		System.out.println("삭제완료");
	}
}
