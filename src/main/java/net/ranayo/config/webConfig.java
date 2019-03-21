package net.ranayo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class webConfig extends WebMvcConfigurationSupport {
    @Bean
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return super.requestMappingHandlerMapping();
    }
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new sessionInterceptor())
        	.addPathPatterns("/admin/**")
        	.addPathPatterns("/content/about")
        	.excludePathPatterns("/users/login-pg"); //로그인 쪽은 예외처리를 한다.
    }
}
