package cn.dkc.dy;
import java.util.Random;
//冒泡排序
/*(我们这块说升序思想)    排序思想：第一趟，从第一个记录开始到第n个记录，
对n-1对相邻的两个记录关键字进行比较，若前者大于后者，两者进行交换，这样一趟结束后，
最大的元素就在数组的末尾；
第二趟，从第一个记录开始到第n-1个记录，对n-2对相邻的两个记录关键字进行比较，
若前者大于后者，两者进行交换，
这样一趟结束，次大元素在数组的倒数第二个位置.....如此进行n-1次排序就能排序出来*/
public class bubbleSort {
	public static void main(String[] args) {
		Random r = new Random();
		int[] arr = new int[10000];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = r.nextInt();
		}
		long t1 = System.currentTimeMillis();
		BubbleSort1(arr);
		long t2 = System.currentTimeMillis();
		System.out.println(t2);
		System.out.println(t1);
		System.out.println(t2 - t1);
		long t3 = System.currentTimeMillis();
		BubbleSort2(arr);
		long t4 = System.currentTimeMillis();
		System.out.println(t3);
		System.out.println(t4);
		System.out.println(t4 - t3);
	}
	
	public static void BubbleSort1(int arr[]) {
		for(int i = 1;i<arr.length;i++) {
			for(int j = 0;j<arr.length-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
//	优化算法：我们加一个条件判断它是否交换，如果没有交换，那么就说明他已经排好序
	public static void BubbleSort2(int arr[]) {
		for(int i = 1;i<arr.length;i++) {
			Boolean b = false;
			for(int j = 0;j<arr.length-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					b = true;
				}
			}
			if(b == true) break;
		}
	}
}
