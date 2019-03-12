package GuiBing;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {2,3,5,1,4,5,6};
		mergeInternal(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeInternal(int[] arr,int low,int high) {
		if(low>=high) return;
		int mid = (high - low)/2+low;
		//左边小数组
		mergeInternal(arr, low, mid);
		//右边小数组
		mergeInternal(arr, mid+1, high);
		//合并
		merge(arr,low,mid,high);
	}
	
	public static void merge(int[] arr,int p,int q,int r) {
		int i = p;
		int j = q+1;
		//定义新数组tmp
		int[] tmp = new int[r-p+1];
		int k = 0;
		//将数组前半部分和后半部分按大小放在tmp数组中
		while(i<=q&&j<=r) {
			if(arr[i]>arr[j]) {
				tmp[k++] = arr[j++];
			}else {
				tmp[k++] = arr[i++];
			}
		}
		//记录当前i和q
		int start = i;
		int end = q;
		//判断后半部分是否全部加入tmp数组中，没有赋给分别将j和r赋给start和end
		if(j<=r) {
			start = j;
			end = r;
		}
		//把剩余元素放在tmp后即可
		while(start<=end) {
			tmp[k++] = arr[start++];
		}
		//将tmp数组值赋给原数组
		/*for(i = 0;i<r-p+1;i++) {
			arr[p+i] = tmp[i];
		}*/
		System.arraycopy(tmp, 0, arr, p, tmp.length);
	}
}
