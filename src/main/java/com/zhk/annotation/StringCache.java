package com.zhk.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 此注解只能标注于方法上。默认缓存时间为60分钟。
 * 此注解会将方法的返回值存入缓存，再次调用此方法时，若缓存中有值，则直接返回缓存的值，否则继续执行此方法。<br/>
 * <span style="color:red">注意：此注解只适用于方法返回值为String类型的方法，key和prefix方法必须赋值，
 * 且key的长度必须大于2。</span><br/>
 * 处理逻辑参见 {@link com.zhk.aspect.StringCacheAspect}
 * @author 赵洪苛
 * @date 2020/8/5 16:15
 * @description 将标注此注解的方法的返回值存入缓存
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StringCache {

    /**
     * 缓存的键，与prefix连接构成缓存中的唯一主键。
     * key值可以通过使用“#”来读取方法参数中的值。
     * 例如：key="#number"，表示从名为number的方法参数中获取值，并将其赋给key。
     * 必须赋值，且长度大于2
     * @return 键值
     */
    String key() default "";

    /**
     * key的前缀字符串，与key中间会使用“-”号连接，可以用前缀区分不同场景。
     * 必须赋值
     * @return 前缀
     */
    String prefix() default "";

    /**
     * 缓存有效时长
     * @return 存活时长
     */
    long live() default 60;

    /**
     * 缓存有效存活时长的单位
     * @return 时长单位
     */
    TimeUnit timeunit() default TimeUnit.MINUTES;

}
