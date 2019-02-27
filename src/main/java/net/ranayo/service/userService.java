package net.ranayo.service;

import java.util.Map;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ranayo.model.user;
import net.ranayo.repository.userRepository;

@Service
public class userService {

	@Autowired
	private userRepository userRe;
	
	@Transactional
	public void coJoin(Map<String, String> map) {
		try {
			user user = new user();
			user.setUsEmail(map.get("usEmail"));
			user.setUsNickname(map.get("usNickname"));
			user.setUsPasswd(map.get("usPasswd"));
			user.setUsJoinip("usJoinip");
			System.out.println("cojoin");
			userRe.save(user);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
