package cn.dkc.dy;

import java.util.Arrays;
import java.util.Random;

/*
 	选择排序
 	
 	思想：
 		第一趟从n个数中找出最小的和第一个元素交换.
 		第二趟从第二个元素开始的n-1个数中找出最小的元素，与第二个元素交换
 		...
 		第i趟从第i元素开始的n-i+1个数中找出最小的元素，与第i个元素交换，直到整个序列有序
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] arr = new int[10000];
		Random r = new Random();
		for(int i = 0;i<arr.length;i++) {
			arr[i] = r.nextInt(10000);
		}
		System.out.println(Arrays.toString(arr));
		long l1 = System.currentTimeMillis();
		selectSort(arr);
		long l2 = System.currentTimeMillis();
		System.out.println(l2-l1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void selectSort(int[] arr) {
		for(int i = 1;i<arr.length;i++) {
			//记录最小值的下标
			int j= i;
			for(int k = i-1;k<arr.length;k++) {
				if(arr[k]<=arr[j])
					j = k;
			}
			if(i!=j) {
				int tmp = arr[j];
				arr[j] = arr[i-1];
				arr[i-1] = tmp;
			}
			
		}
	}
}
