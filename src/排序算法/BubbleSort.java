package 排序算法;

import java.util.Arrays;

/**
 * 冒泡排序
 * @Title:BubbleSort
 * @Description:
 * @author sky
 * @date 2018年4月27日
 */
public class BubbleSort {

	public static void bubbleSort(int[] arg) {
		//冒泡排序，一次比较，较小的交换。交换在内循环，所以效率较低
		for(int i=0;i<arg.length-1;i++) {
			for(int j=i+1;j<arg.length;j++) {
				if(arg[i]>arg[j]) {
					//arg[i]大于arg[j]，则交换位置
					arg[j]=arg[i]+arg[j];
					arg[i]=arg[j]-arg[i];
					arg[j]=arg[j]-arg[i];
				}
			}
		}
	}
	
	/**
	 * 冒泡排序优化
	 * @method: bubbleSortLevelUp 
	 * @param a 
	 * @return void
	 */
	public static void bubbleSortLevelUp(int[] a) {
		
	}
	
	
	public static void main(String[] args) {
		int[] arg = {1,31,6,53,92,61,23,102,8,24};
		System.out.println(Arrays.toString(arg));
		bubbleSort(arg);
		System.out.println(Arrays.toString(arg));
	}
}
