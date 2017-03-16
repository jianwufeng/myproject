package com.crm.util.excel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ExcelAnnotations {

    // 提示错误信息
    String msg() default "";

    // 允许为空
    boolean isAllowNull() default false;
}
