package com.tobyspring.helloboot;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

public class HellobootApplication {

    // 빈 서블릿 컨테이너 만들기 ( 내장형 톰캣 라이브러리가 이미 존재 )
    public static void main(String[] args) {
//        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer();
        webServer.start();

    }
}
