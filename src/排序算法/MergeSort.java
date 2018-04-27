package 排序算法;

import java.util.Arrays;

/**
 * 归并排序
 * @Title:MergeSort
 * @Description:
 * @author sky
 * @date 2018年4月27日
 */
public class MergeSort {
	
	//分治思想(其实有点像动态规划，微积分，将大问题分成一个个规律相同的小问题，然后处理)
	public static void mergeSort(int[] a,int L,int R) {
		//如果只有一个元素，则停止拆分
		if(L == R) {
			return;
		}else {
			// 取中间数
			int mid = (L+R)/2;
			//左边不断拆分
			mergeSort(a, L, mid);
			//右边不断拆分
			mergeSort(a, mid+1, R);
			//合并
			merge(a, L, mid+1, R);
		}
	}
	
	//合并数组
	public static void merge(int[] a,int L,int M,int R) {
		//左边的数组大小
		int[] leftArray = new int[M-L];
		//右边的数组大小
		int[] rightArray = new int[R-M+1];
		//往数组中填充数据
		for(int i=L;i<M;i++) {
			leftArray[i-L] = a[i];
		}
		for(int i=M;i<=R;i++) {
			rightArray[i-M] = a[i];
		}
		int i=0,j=0;
		//a数组的第一个元素
		int k=L;
		//比较这两个数组的值，哪个小就放入数组
		while(i<leftArray.length && j < rightArray.length) {
			//谁比较小，就将元素放入数组，并将指针后移
			if(leftArray[i]<rightArray[j]) {
				a[k]=leftArray[i];
				i++;
				k++;
			}else {
				a[k]=rightArray[j];
				j++;
				k++;
			}
		}
		//如果左边数组还未比较完，则将左边数组都加入大数组
		while(i < leftArray.length) {
			a[k] = leftArray[i];
			i++;
			k++;
		}
		//同上
		while(j < rightArray.length) {
			a[k]=rightArray[j];
			j++;
			k++;
		}
	}
	
	
	public static void main(String[] args) {
		int[] a= {12,214,5,342,64,674,23,53,1,534,67,342,85};
		mergeSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
}
