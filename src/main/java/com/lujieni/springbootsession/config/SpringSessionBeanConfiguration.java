package com.lujieni.springbootsession.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieHttpSessionIdResolver;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.session.web.http.HttpSessionIdResolver;

@Configuration
public class SpringSessionBeanConfiguration {
    @Value("${spring.session.cookieName:'JSESSIONID'}")
    private String cookieName;

    //Cookie配置
    @Bean
    public CookieSerializer cookieSerializer(){
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        cookieSerializer.setCookieName(cookieName);//sessionId名称
        return  cookieSerializer;
    }

    //HttpSessionId配置
    @Bean
    public HttpSessionIdResolver httpSessionIdResolver(){
        CookieHttpSessionIdResolver cookieHttpSessionIdResolver = new CookieHttpSessionIdResolver();
        cookieHttpSessionIdResolver.setCookieSerializer(cookieSerializer());
        return cookieHttpSessionIdResolver;
    }
}


