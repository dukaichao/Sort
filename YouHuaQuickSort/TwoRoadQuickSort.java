package YouHuaQuickSort;

public class TwoRoadQuickSort {
	public static void main(String[] args) {
		int[] arr = {5,4,13,2,1,10,8,9,7,6};
		Partition_II(arr,0,arr.length-1);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	public static void Partition_II(int[] arr,int l,int r) {
		if(l >= r) return;
		int q = Partition_I(arr, l, r);
		Partition_II(arr, l, q-1);
		Partition_II(arr, q+1, r);
		
	}
	public static int Partition_I(int arr[], int l, int r){
		//返回下标l - r之间的任意数
		int randIndex = (int) ((Math.random() * (r - l + 1)) + l);
		swap(arr,l,randIndex);
		//默认基准值为第一个元素
		int t = arr[l];
		//arr[l+1....i-1] < v
		int i = l + 1;
		//arr[j+1....r] > v
		int j = r;
		while(true) {
			while(i<=r && arr[i] < t) i++;
			while(j>=l+1 && arr[j] > t) j--;
			if(i > j) {
				break;
			}else {
				swap(arr,i,j);
				i++;
				j--;
			}
		}
		//交换l与j的元素
		swap(arr,l,j);
		return j;
	}
	
	public static void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
