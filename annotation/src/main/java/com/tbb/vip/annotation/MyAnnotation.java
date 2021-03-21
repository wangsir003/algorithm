package com.tbb.vip.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Create By WangSir on 2021/2/24 0024
 */

@Documented
@Retention(RetentionPolicy.RUNTIME) //作用时机：类CLASS 运行时RUNTIME 资源SOURCE
@Target({ElementType.METHOD,ElementType.CONSTRUCTOR}) //作用位置：方法：变量,CONSTRUCTOR 等
@interface MyAnnotation {
    int id() default 0;
    String[] value();
}
