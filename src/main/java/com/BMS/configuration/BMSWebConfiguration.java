package com.BMS.configuration;

import com.BMS.interceptor.LoginRequiredInterceptor;
import com.BMS.interceptor.PassportInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@Component
public class BMSWebConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    LoginRequiredInterceptor loginRequiredInterceptor;
    @Autowired
    PassportInterceptor passportInterceptor;


    @Override

    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(passportInterceptor);

        registry.addInterceptor(loginRequiredInterceptor).addPathPatterns("/showIndex");


        super.addInterceptors(registry);
    }

}
