package cn.dkc.dy;

import java.util.Arrays;
import java.util.Random;

/*
 	希尔排序
 	
 	我们先在方法中找出它最大的间隔h，
 	第一趟，将要排序的一组数按增量h分成若干组，每组中记录的下标相差h，
 	对每组中全部元素进行排序。
 	第二趟，间隔为h = (h-1)/3,以后的每趟间隔都是h = (h-1)/3,
 	直到间隔变为1，整个要排序的数被分成一组，排序完成。
	
	一般的初次取序列的一半为增量，以后每次减半，直到增量为1。
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] arr = new int[10000];
		Random r = new Random();
		for(int i = 0;i<arr.length;i++) {
			arr[i] = r.nextInt(100000);
		}
		long l1 = System.currentTimeMillis();
		shellSort(arr);
		long l2 = System.currentTimeMillis();
		System.out.println(l2-l1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void shellSort(int[] arr) {
		//临时变量，储存当前元素
		int h = 1;
		//计算最大间隔
		while(h<arr.length/3) {
			h = h*3 + 1;
		}
		
		while(h>0) {
			int tmp = 0;
			for(int i = h;i<arr.length;i++) {
				tmp = arr[i];
				int j = i;
				while(j>h - 1&&arr[j-h]>=tmp) {
					arr[j] = arr[j-h];
					j -= h;
				}
				arr[j] = tmp;
			}
			//减少间隔
			h = ( h - 1) / 3;
		}
	}
}
