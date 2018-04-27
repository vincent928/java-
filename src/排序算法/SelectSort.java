package 排序算法;

import java.util.Arrays;

/**
 * 选择排序
 * @Title:SelectSort
 * @Description:
 * @author sky
 * @date 2018年4月27日
 */
public class SelectSort {

	public static void selectSort(int[] a) {
		//选择排序，找出最小值排在前面，需要临时变量minValue存储最小值，index存储下标
		//交换在外循环，所以效率较高
		for(int i=0;i<a.length-1;i++) {
			int minValue=a[i];
			int index = i ;	
			int c = 0;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<minValue) {
					minValue = a[j];
					index = j;
				}
			}
			c = a[index];
			a[index] = a[i];
			a[i] = c;
		}
	}
	
	public static void main(String[] args) {
		int[] arg = {1,31,6,53,92,61,23,102,8,24};
		System.out.println(Arrays.toString(arg));
		selectSort(arg);
		System.out.println(Arrays.toString(arg));
	}
}
