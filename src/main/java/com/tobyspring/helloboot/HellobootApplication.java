package com.tobyspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpHeaders;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

public class HellobootApplication {

    // 빈 서블릿 컨테이너 만들기 ( 내장형 톰캣 라이브러리가 이미 존재 )
    public static void main(String[] args) {
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
        applicationContext.registerBean(HelloController.class); // 스프링 빈으로 등록
        applicationContext.registerBean(SimpleHelloService.class);
        applicationContext.refresh();

        //TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        //아래처럼 추상화 계층을 사용하면 jetty 등을 사용할 수 있다.
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("dispatcherServlet", new DispatcherServlet(applicationContext))
                    .addMapping("/*");
        });
        webServer.start();
    }
}