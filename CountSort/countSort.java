package CountSort;

import java.util.Arrays;

/*
 	计数排序：
 		时间复杂度是O(数组长度+最大值和最小值差)
 		空间复杂度O(最大值和最小值差)
 	适用于连续的数组
 */
public class countSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {90,94,92,93,94,94,95,100,100,98,97,98,97};
		System.out.println(Arrays.toString(countsort(arr)));
		
	}
	
	public static int[] countsort(int[] arr) {
		int max = arr[0];
		int min = arr[0];
		//找出最大值和最小值
		for(int i = 0;i<arr.length;i++) {
			if(arr[i] > max)
				max = arr[i];
			if(arr[i] < min)
				min = arr[i];
		}
		//最大值减去最小值表示间距
		int d = max - min;
		//定义统计数组，统计对应元素个数
		int[] array = new int[d+1];
		for(int i = 0;i<arr.length;i++) {
			array[arr[i] - min]++;
		}
		
		//统计数组做变形,后面的元素等于前面元素之和
		/*
		 	统计数组从第二个元素开始，每一个元素都加上前面所有元素之和，这样想加的目的是让统计
		 	数组存储的元素值等于相应整数的最终排序位置
		 */
		int sum = 0;
		for(int i = 0;i<array.length;i++) {
			sum += array[i];
			array[i] = sum;
		}
		/*
		 	接下来我们创建新数组，长度和传入数组一致。然后从后向前遍历输入数组
		 	第一步，我们遍历数组最后一个元素，然后在统计数组array中找到其对应的下标的元素
		 	该元素表示其排序位置，然后该元素减1,
		 	第二步，遍历倒数第二个元素，方法和上面一样......
		 */
		//倒序遍历原始数组，从统计数组找到正确位置，输出到结果数组
		int[] countArray = new int[arr.length];
		for(int i = arr.length - 1;i>=0;i--) {
			countArray[array[arr[i] - min] - 1] = arr[i];
			array[arr[i] - min]--;
		}
		return countArray;
	}
	
}
