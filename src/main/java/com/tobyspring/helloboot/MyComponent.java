package com.tobyspring.helloboot;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 언제적용
@Target(ElementType.TYPE) // 적용대상
@Component
public @interface MyComponent {
}
