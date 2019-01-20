package cn.dkc.dy;

import java.util.Arrays;
import java.util.Random;
//折半插入排序
/*1.每次插入，都从前面的有序子表中查找出待插入元素应该被插入的位置； 
	2.给插入位置腾出空间，将待插入元素复制到表中的插入位置。 
注意到该算法中，总是边比较边移动元素，下面将比较和移动操作分离开来，
即先折半查找出元素的待插入位置，然后再统一地移动待插入位置之后的所有元素。*/
public class BInsertSort {
	public static void main(String[] args) {
		int[] arr = new int[10000];
		Random r = new Random();
		for(int i = 0;i<arr.length;i++) {
			arr[i] = r.nextInt(100000);
		}
		BinaryInsertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void BinaryInsertSort(int[] arr) {
		for(int i = 1;i<arr.length;i++) {
			if(arr[i]<arr[i-1]) {
				int low = 0;
				int high = i - 1;
				int t = arr[i];
				while(low<=high) {//判断插入位置
					int mid = (high-low)/2+low;
					if(t<arr[mid]) {
						high = mid - 1;  //在低半区
					}else
						low = mid + 1;   //在高半区
				}
				for(int j = i - 1;j>=high+1;j--) {
					arr[j+1] = arr[j];
				}
				arr[high+1] = t;
			}
		}
	}
}
