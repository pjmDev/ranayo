package net.ranayo.config;

import net.ranayo.config.AuthProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
@ComponentScan(basePackages = {"net.ranayo.*"})
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
    AuthProvider authProvider;
    @Autowired
    AuthFailureHandler authFailureHandler;
    @Autowired
    AuthSuccessHandler authSuccessHandler;
 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.
			authorizeRequests()
				.antMatchers("/*").permitAll()
				.antMatchers("/**").permitAll()
				.antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
				.authenticated().and().csrf().disable()
				.formLogin()
				.loginPage("/users/login-pg")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/")
				.failureHandler(authFailureHandler)
	            .successHandler(authSuccessHandler)
				.usernameParameter("usEmail")
				.passwordParameter("usPasswd")
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"))
				.logoutSuccessUrl("/").and().exceptionHandling()
				//.accessDeniedPage("/")
				.and()
				.authenticationProvider(authProvider);;
		

	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/static/lib/css/**", "/static/js/**", "/static/data/**", "/templates/**");
	}
	
}
