package YouHuaQuickSort;
/*
 * 
 * 三路快排
 */
import java.util.Arrays;

public class QuickSort3 {
	
	public static void main(String[] args) {
		int[] arr = {1,5,4,2,3,6,8,4,1,2};
		quickSortInternal3(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	
	public static void quickSortInternal3(int[] arr,int l,int r) {
		if(l >= r) return;
		int randIndex = (int)(Math.random() * (r - l + 1) + l);
		swap(arr,l,randIndex);
		int v = arr[l];
		//arr[l+1.....lt] < v
		int lt = l;
		//arr[gt....r] > v
		int gt = r + 1;
		int i = l + 1;
		while(i<gt) {
			if(arr[i] < v) {
				swap(arr,lt+1,i);
				lt++;
				i++;
			}else if(arr[i] > v) {
				swap(arr,gt-1,i);
				gt--;
			}else {
				i++;
			}
		}
		swap(arr,l,lt);
		quickSortInternal3(arr, l, lt-1);
		quickSortInternal3(arr, gt, r);
	}
	
	public static void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
