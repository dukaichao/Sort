package cn.dkc.dy;

import java.util.Arrays;

/*
 快速排序
	设置两个搜索指针low和high，它们分别指向首尾，
	从high位置开始搜索比支点小的记录，并将其交换到low位置处，low向后移动一个位置，
	然后从low位置开始搜索比支点大的位置，并将其交换到high位置处，high向前移动一个位置
	如此继续，直到low和high相等结束，这时支点前面的数全小于它，后面全比它大，
	然后将支点前面和后面的序列继续进行排序，直到完成排序
	
*/
public class quickSort {
	public static void main(String[] args) {
		int[] arr = {5,4,13,2,1,10,8,9,7,6};
		Partition(arr,0,arr.length-1);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	
	public static void Partition(int arr[], int head, int tail)
	{
		int low = head;
		int high = tail;
		int t = 0;    //记录支点数值
		if (low<high) {
			t = arr[low];   //通常我们记录第一个元素为支点
			while (low<high) {
				while (low < high && t <= arr[high]) {
					high--;
				}
				if (low < high) {
					arr[low] = arr[high];
					low++;
				}
				while (low < high && arr[low] <= t) {
					low++;
				}
				if (low < high) {
					arr[high] = arr[low];
					high--;
				} 
			}
			//将支点元素赋给第一次排序后的high或者low位置
			arr[high] = t;
			Partition(arr,head,low-1);
			Partition(arr,high+1,tail);
		}
		
	}
}
