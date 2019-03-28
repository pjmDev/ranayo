package net.ranayo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class webConfig extends WebMvcConfigurationSupport {
	private static final String[] RESOURCE_LOCATIONS = {
	        "classpath:/static/"
	        };
	
    @Bean
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return super.requestMappingHandlerMapping();
    }
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new sessionInterceptor())
        	.addPathPatterns("/admin/**") //인터셉터를 사용할 URL 지정
        	.addPathPatterns("/content/about")
        	.excludePathPatterns("/users/login-pg"); //해당 URL은 인터셉터 사용 안함
        
    }
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
        .addResourceHandler("/**")
        .addResourceLocations(RESOURCE_LOCATIONS)
        .setCachePeriod(3600)
        .resourceChain(true)
        .addResolver(new PathResourceResolver());
    }
}
