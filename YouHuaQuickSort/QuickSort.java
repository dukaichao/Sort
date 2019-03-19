package YouHuaQuickSort;

public class QuickSort {
	
	public static void Partition(int arr[], int head, int tail) {
		int low = head;
		int high = tail;
		int t = 0;    //记录支点数值
		if (low<high) {
			int randIndex = (int) ((Math.random() * (tail - head + 1)) + head);
			swap(arr,low,randIndex);
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
			Partition(arr,head,high-1);
			Partition(arr,high+1,tail);
		}
	}
	
	public static void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
