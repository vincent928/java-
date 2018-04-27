package 集合;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * ListIterator测试
 * @Title:IteratorDemo
 * @Description:
 * @author sky
 * @date 2018年4月26日
 */
public class IteratorDemo {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		ListIterator<Integer> iterator = list.listIterator();
		while (iterator.hasNext()) {
			Integer ok = (Integer) iterator.next();
			System.out.println("迭代次数："+ok);
		}
		while(iterator.hasPrevious()) {
			//返回前一个的index
			//int i = iterator.previousIndex();
			int i = iterator.previous();
			System.out.println(i);
		}
		
	}
}
