package com.board;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.board.intercepter.CreateIntercepter;

@Configuration
public class WebConfiguration implements WebMvcConfigurer{

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CreateIntercepter())
                .addPathPatterns("/api/v1/question/**");

    }
}
