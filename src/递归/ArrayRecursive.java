package 递归;

/**
 * 数组递归
 * @Title:ArrayRecursive
 * @Description:
 * @author sky
 * @date 2018年4月27日
 */
public class ArrayRecursive {

	/**
	 * 递归数组求最大值
	 * @method: arrayRecursive 
	 * @param a 
	 * @return void
	 */
	public static int arrayRecursive(int[] a,int point) {
		int j = a.length;
		if(j-point == 0 ) {
			return a[0];
		}else {
			//实际就是a[0]依次和a[n],a[n-1],a[n-2]比较，较大值放入a[0]
			if(a[0]<a[j-point]) {
				a[0] = a[j-point];
			}
			point++;
			return arrayRecursive(a, point);
		}
	}
	public static void main(String[] args) {
		int[] a= {21,123,415,26,745,234,52,643,-51};
		int i = arrayRecursive(a,1);
		System.out.println(i);
	}
}
