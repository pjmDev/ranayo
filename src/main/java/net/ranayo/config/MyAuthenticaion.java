package net.ranayo.config;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import net.ranayo.model.user;

@Data
public class MyAuthenticaion extends UsernamePasswordAuthenticationToken {

	private  static final long serialVersionUID = 1L;

    user user;

    public MyAuthenticaion (String id, String password, List<GrantedAuthority> grantedAuthorityList, user user) {
        super(id, password, grantedAuthorityList);
        this.user = user;
    }

}
