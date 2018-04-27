package 注解;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @Title:MyAnnotation
 * @Description: 自定义注解
 * @author sky
 * @date 2018年4月26日
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	
	// 定义两个成员变量
	String name() default "张三";
	int age() default 23;
	
	//将自定义的注解基本信息关联到方法上，利用反射实现
	
	
	
}
