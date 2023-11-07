package com.my.docker2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration

@EnableWebMvc //HandlerAdapter가 messageConvert하도록 설정,
			  //WebApplicationContext타입의 스프링컨테이너가 된다
public class MyMVCContext implements WebMvcConfigurer{
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver r = new InternalResourceViewResolver();
		r.setPrefix("/WEB-INF/view/");
		r.setSuffix(".jsp");
		return r;
	}
	
//	@Bean
//	public CommonsMultipartResolver multipartResolver() {
//		CommonsMultipartResolver r = new CommonsMultipartResolver();
//		r.setDefaultEncoding("UTF-8");
//		r.setMaxUploadSize(100*1024);
//		r.setMaxUploadSizePerFile(10*1024);
//		return r;
//	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		WebMvcConfigurer.super.addCorsMappings(registry);
		registry.addMapping("/**")
				.allowCredentials(true)
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowedOrigins("http://192.168.1.20:5500");
	}
	
}
