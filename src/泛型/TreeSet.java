package 泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Title:TreeSet
 * @Description:泛型通配符下限
 * @author sky
 * @date 2018年4月26日
 */
public class TreeSet {

	public static void test(List<? extends Number> list) {
		List a = new ArrayList<>();
//		a = list;
		list = a;
	}
	
	public static void main(String[] args) {
		
		
		
	}
	
}
