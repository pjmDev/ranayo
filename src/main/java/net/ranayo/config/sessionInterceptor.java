package net.ranayo.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class sessionInterceptor extends HandlerInterceptorAdapter {
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("userState");
		
		if(obj != null ) { return true; }//세션에 계정 정보가 존재하는 경우
        else {
            try {
            	System.out.println(session.getAttribute("usEmail"));
            	response.setContentType("text/html; charset=UTF-8");
    			PrintWriter out = response.getWriter();
    			out.println("<script>alert('로그인 해주세요');location.href=\"/users/login-pg\";</script>");
    			//response.sendRedirect("/users/login-pg"); 
    			out.flush();
    			
            }
        
            catch (IOException ie ) {} //만약 리다이렉션 도중 에러가 난 경우
		//log.info("Interceptor > preHandle");
        return false;
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //log.info("Interceptor > postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3) throws Exception {
        //log.info("Interceptor > afterCompletion" );
    }
}
