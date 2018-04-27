package 排序算法;

import java.util.Arrays;

/**
 * 插入排序
 * @Title:InsertSort
 * @Description:
 * @author sky
 * @date 2018年4月27日
 */
public class InsertSort {

	/**
	 * 将数组看作有序数组，后面元素插入有序元素
	 * @method: insertSort 
	 * @param a 
	 * @return void
	 */
	public static void insertSort(int[] a) {
		//将a[i]看做有序 序列 ，和前一个不断比较
		int temp;
		for(int i=1;i<a.length;i++) {
			temp = a[i];
			while(i>=1 && a[i-1] > temp) {
				a[i] = a[i-1];
				i--;
			}
			a[i] = temp;
		}
	}
	
	/**
	 * 利用二分法减少比较次数。优化查询速度
	 * @method: insertAndBinarySort  
	 * @return void
	 */
	public static void insertAndBinarySort(int[] a) {
		int temp;
		int index;
		for(int i =1;i<a.length;i++) {
			temp = a[i];
			index = i/2;
			// {12,32,45} {27} i=3
			while(a[index]>temp) {
				a[i]=a[index];
				
				if(index >0)
					index--;
			}
			a[index]=temp;	
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] a= {32,12,45,27,4,75,56,2};
		insertSort(a);
		System.out.println(Arrays.toString(a));
	}
}
