package dkc_dy1;

import java.util.Arrays;
/*堆排序的基本思想(大顶堆)

	1) 先将初始排列关键字序列(R1,R2...,Rn-1,Rn)构成大顶堆，此堆为初始的无序区.
	(这里是从最后一个非叶结点向前进行赛选)
	
	2)将堆顶元素R1与最后一个元素Rn交换，此时得到新的无序区(R1,R2...,Rn-1)和新的有序区(Rn)，
	并且Rn大于无序区所有数，此后还有n-1个数；
	
	3)由于交换后新的堆顶R1可能违反堆的性质，因此需要对当前无序区(R1,R2...,Rn-1)
	调整为新堆(将堆顶元素向下调整使其保持大顶堆的性质，输出堆顶元素)，此后还剩余n-2个数；
	
	4)重读以上算法，直到堆中仅剩一个元素为止.
*/
public class HeapSort {
	
	public static void main(String[] args) {
		int[] arr1 = {6,5,2,8,9,1,3,7,4};
		//SmallHeapSort(arr1);
		int[] arr2 = {6,5,2,8,9,1,3,7,4};
		BigHeapSort(arr2);
	}
	
	//arr：堆数据      len：堆中有效数据个数  		k:待筛选结点
	public static void SmallHeapOne(int[] arr, int len, int k) {
		int left = 2*k + 1;   //左孩子
		int right = 2*k + 2;  //右孩子
		if(left >= len && right >= len)		//已经是叶子
			return;
		int tmp1 = Integer.MAX_VALUE;
		int tmp2 = Integer.MAX_VALUE;
		if(left < len)
			tmp1 = arr[left];
		if(right < len)
			tmp2 = arr[right];
		
		if(tmp1 > arr[k] && tmp2 > arr[k])	//满足要求，直接返回
			return;
		
		//找到左右孩子数最小的交换
		if(tmp1 < tmp2) {
			int tmp = arr[k];
			arr[k] = arr[left];
			arr[left] = tmp;
			SmallHeapOne(arr,len,left);
		}else {
			int tmp = arr[k];
			arr[k] = arr[right];
			arr[right] = tmp;
			SmallHeapOne(arr,len,right);
		}	
	}

	public static void SmallHeapSort(int[] arr) {
		//建立初始堆
		for(int i = (arr.length - 1)/2;i>=0;i--) {
			SmallHeapOne(arr,arr.length,i);
			System.out.println(Arrays.toString(arr));
		}
		//边输出堆顶边调整
		int len = arr.length;
		while(len>0) {
			System.out.print(arr[0]+" ");
			arr[0] = arr[len - 1];
			len--;
			SmallHeapOne(arr,len,0);
		}
		System.out.println();
	}
	
	public static void BigHeapSort(int[] arr) {
		//建立初始堆
		for(int i = (arr.length - 1)/2;i>=0;i--) {
			System.out.println(arr[i]);
			BigHeapOne(arr,arr.length,i);
			System.out.println(Arrays.toString(arr));
		}
		//边输出堆顶边调整
		int len = arr.length;
		while(len>0) {
			System.out.print(arr[0]+" ");
			arr[0] = arr[len - 1];
			len--;
			BigHeapOne(arr,len,0);
		}
		System.out.println();
	}
	public static void BigHeapOne(int[] arr, int len, int k) {
		int left = 2*k + 1;   //左孩子
		int right = 2*k + 2;  //右孩子
		if(left >= len && right >= len)		//已经是叶子
			return;
		int tmp1 = 0;
		int tmp2 = 0;
		if(left < len)
			tmp1 = arr[left];
		if(right < len)
			tmp2 = arr[right];
		
		if(tmp1 < arr[k] && tmp2 < arr[k])	//满足要求，直接返回
			return;
		
		//找到左右孩子数最小的交换
		if(tmp1 > tmp2) {
			int tmp = arr[k];
			arr[k] = arr[left];
			arr[left] = tmp;
			BigHeapOne(arr,len,left);
		}else {
			int tmp = arr[k];
			arr[k] = arr[right];
			arr[right] = tmp;
			BigHeapOne(arr,len,right);
		}
			
	}
}
