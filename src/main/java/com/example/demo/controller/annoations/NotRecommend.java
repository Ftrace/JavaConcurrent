package com.example.demo.controller.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来标记【不推荐】的类和写法
 */
@Target(ElementType.TYPE) //注解作用的目标，TYPE(类，接口（包括注释类型）或枚举声明)
@Retention(RetentionPolicy.SOURCE) //注解存在的范围,SOURCE（将被编译器丢弃）
public @interface NotRecommend {
    String value() default "";
}
