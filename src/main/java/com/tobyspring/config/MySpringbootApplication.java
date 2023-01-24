package com.tobyspring.config;

import com.tobyspring.config.EnableMyAutoConfiguration;
import com.tobyspring.config.autoconfig.DispatcherServletConfig;
import com.tobyspring.config.autoconfig.TomcatWebServerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // 클래스, 인터페이스, inner 에 부여가능
@Configuration
@ComponentScan
@EnableMyAutoConfiguration
public @interface MySpringbootApplication {
}
