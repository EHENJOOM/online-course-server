package com.zhk.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 此自定义注解是为防止接口在短时间内重复提交。此注解有num（一定时间内最多允许接口访问的次数，默认为1）、
 * interval（时间限制数，默认为60）、timeunit（时间单位，默认为秒）3个属性
 * 因此，标注了此注解的接口，默认为60秒内仅允许访问1次，用户可根据不同接口进行属性的修改。
 * @author 赵洪苛
 * @date 2020/7/30 20:16
 * @description 自定义注解，防止接口重复提交
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PreventRepeatSubmit {

    /**
     * 在一个{@link #interval()}时间内允许此接口呗调用的最多次数
     * @return
     */
    int num() default 1;

    /**
     * 允许此接口在{@link #interval()}时间内调用{@link #num()}次
     * @return
     */
    long interval() default 60;

    /**
     * 此参数为{@link #interval()}的单位，默认为秒
     * @return
     */
    TimeUnit timeunit() default TimeUnit.SECONDS;

}
