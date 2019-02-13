package maopaoYH;

public class BubbleSort {
	public static void BubbleSort3(int arr[]) {
		//无序数列边界
		int rightboard = arr.length - 1;
		//记录最后一次交换的位置
		int lastexchange = 0;
		for(int i = 1;i<arr.length;i++) {
			Boolean b = true;
			for(int j = 0;j<rightboard;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					b = false;
					lastexchange = j;
				}
			}
			rightboard = lastexchange;
			if(b) break;
		}
	}
}
