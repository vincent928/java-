package 排序算法;

import java.util.Arrays;

/**
 *  快速排序,递归思想
 * @Title:QuickSort
 * @Description:
 * @author sky
 * @date 2018年4月27日
 */
public class QuickSort {

	/**
	 * 通过指定一个中间点，分为左右两个部分，左边都比中间点小，右边都比中间点大。递归
	 * 出口即只剩一个元素时候
	 * @method: quickSort 
	 * @param a 数组 
	 * @param L 数组第一个元素
	 * @param R 数组最后一个元素
	 * @return void
	 */
	public static void quickSort(int[] a,int L,int R) {
		int i = L;
		int j = R;
		int mid = a[(L+R)/2];
		//左右两端
		while(i<=j) {
			//寻找直到比支点大的数
			while(mid > a[i]) {
				i++;
			}
			//找到比支点小的数
			while(mid < a[j]) {
				j--;
			}
			//此时已经找到比支点小的数(右边),比支点大的数(左边)
			if(i<=j) {
				int temp= a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		//上面的while循环保证了第一次排序的左边比支点都小，右边比支点都大。
		//左边再继续排序，直到左边只剩 1个数
		if(L < j) {
			quickSort(a, L, j);
		}
		//右边再继续排序，直到右边只剩1个数
		if(i < R) {
			quickSort(a, i, R);
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] a= {12,214,5,342,64,674,23,53,1,534,67,342,85};
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
