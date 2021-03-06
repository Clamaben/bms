package com.BMS.controller;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorController {
    @Bean    //此注解一定记住要加上，别忘记
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
//
//                //状态码               错误页面的存储路径
//               ErrorPage errorPage400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/error");
//               ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
//               ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error");
//
//            container.addErrorPages(errorPage400, errorPage404, errorPage500);
            }
        };
    }
}