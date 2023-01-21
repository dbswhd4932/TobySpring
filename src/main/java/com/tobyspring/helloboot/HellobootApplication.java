package com.tobyspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpClient;

public class HellobootApplication {

    // 빈 서블릿 컨테이너 만들기 ( 내장형 톰캣 라이브러리가 이미 존재 )
    public static void main(String[] args) {
        //TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        //아래처럼 추상화 계층을 사용하면 jetty 등을 사용할 수 있다.
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    resp.setStatus(HttpServletResponse.SC_OK);
                    resp.setHeader("Content-Type","text/plain");
                    resp.getWriter().print("Hello Servlet");
                }
            }).addMapping("/hello");
        });
        webServer.start();
    }
}
