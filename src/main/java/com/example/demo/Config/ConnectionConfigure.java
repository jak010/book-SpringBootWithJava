package com.example.demo.Config;

import com.example.demo.InterCeptor.ConnectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan
public class ConnectionConfigure implements WebMvcConfigurer {

    @Autowired
    ConnectInterceptor connectInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(connectInterceptor)
                .addPathPatterns("/*")
                .excludePathPatterns("/token"); // "/token" 요청만 허용해줌
    }
}
