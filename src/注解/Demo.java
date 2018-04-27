package 注解;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {

	@MyAnnotation()
	public void add(String name, int age)  {
		System.out.println("name:"+name+";age:"+age);
	}
	//枚举 
	enum Day{
		MONDAY,TUESDAY,
		SUNDAY
	}
	
	public static void main(String[] args)throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//反射出该类的方法
				Class aClass=Demo.class;
				Method method = aClass.getMethod("add", String.class,int.class);
				
				// 通过该方法得到注解上的信息
				MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
				String username = annotation.name();
				int userage = annotation.age();
				
				// 将注解上的信息注入到方法中
				Object o = aClass.newInstance();
				method.invoke(o, username,userage);
				Day day = Day.MONDAY;
				String a=new String();
				System.out.println("a"+a+"a");
	}
	
}
