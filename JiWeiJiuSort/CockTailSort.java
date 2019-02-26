package JiWeiJiuSort;

import java.util.Arrays;
import java.util.Random;

/*
 	鸡尾酒排序：
 		排序过程第一轮从左向右，第二轮从右向左，第三轮从左向右...
 	优缺点：
 		优点：在特定的条件下，减少排序回合数
 		缺点：代码量扩大
 	什么时候用鸡尾酒排序：大部分已经排序好，这样就可以方便用其
 */
public class CockTailSort {
	
	public static void main(String[] args) {
		int[] arr = new int[10000];
		Random r = new Random();
		for(int i = 0;i<arr.length;i++) {
			if(i<1000)
				arr[i] = i+1;
			else
				arr[i] = r.nextInt(1000)+1000;
		}
		arr[arr.length-2] = 1;
		System.out.println(Arrays.toString(arr));
		
		long l1 = System.currentTimeMillis();
		System.out.println(l1);
		Sort(arr);
		long l2 = System.currentTimeMillis();
		System.out.println(l2);
		System.out.println(l2 - l1);
		long l3 = System.currentTimeMillis();
		System.out.println(l3);
		bubbleSort(arr);
		long l4 = System.currentTimeMillis();
		System.out.println(l4);
		System.out.println(l4 - l3);
		
	}
	
	public static void Sort(int[] arr) {
		int tmp = 0;
		//记录右侧最后一次交换的位置
		int lastRightExchangeIndex = 0;
		//记录左侧最后一次交换的位置
		int lastLeftExchangeIndex = 0;
		//无序数列的左边界
		int rightBoard = arr.length - 1;
		//无序数列的右边界
		int leftBoard = 0;
		for(int i = 0;i<arr.length/2;i++) {
			//有序标记
			boolean b = true;
			//奇数轮从左向右
			for(int j = leftBoard;j<rightBoard;j++) {
				if(arr[j]>arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					b = false;
					lastRightExchangeIndex = j;
				}
			}
			rightBoard = lastRightExchangeIndex;
			//偶数轮前重新标记true
			if(b) break;
			//偶数轮从右向左
			b = true;
			for(int j = rightBoard;j>leftBoard;j--) {
				if(arr[j]<arr[j-1]) {
					tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
					b = false;
					lastLeftExchangeIndex = j;
				}
			}
			leftBoard = lastLeftExchangeIndex;
			if(b) break;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void bubbleSort(int[] arr) {
		int tmp = 0;
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0;j<arr.length - i - 1;j++) {
				if(arr[j]>arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
