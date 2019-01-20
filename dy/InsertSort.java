package cn.dkc.dy;

import java.util.Arrays;
import java.util.Random;
//直接插入排序
/*	排序思想
 	1.从第一个元素开始，我们认为第一个元素已经被排序

	2.取出下一个元素，在已经排序的元素序列中从后向前扫描

	3.如果该元素（已排序）大于新元素，将该元素移到下一位置

	4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置，将新元素插入到该位置
	
	5.执行第二步骤，直到所有元素遍历完
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] arr = new int[10000];
		Random r = new Random();
		for(int i = 0;i<arr.length;i++) {
			arr[i] = r.nextInt(100000);
		}
		long l1 = System.currentTimeMillis();
		insertSort(arr);
		long l2 = System.currentTimeMillis();
		System.out.println(l2-l1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void insertSort(int[] arr) {
		int j = 0;
		for(int i = 1;i<arr.length;i++) {
			if(arr[i]<arr[i-1]) {
				int t = arr[i];  //记录当前位置元素
				for(j = i - 1;j>=0&&t<arr[j];j--) {
					arr[j+1] = arr[j];
				}
				arr[j+1] = t;
			}
		}
	}
	
	
}
