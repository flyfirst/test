package com.example.xiao.test.test;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by xiao on 2016/1/21.
 */

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface level {
    String value() default "";
}
