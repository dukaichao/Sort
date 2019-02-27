package BucketSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * 
 * @author Mr.Du
 * 
 * Data:2019-02-27
 * 
 * 
 * 桶排序：桶排序中的桶是什么概念呢？每一个桶代表一个区间范围，里面可以承载一个或多个元素。
 * 	第一步就是创建这些桶，确定每一个桶的区间范围，具体建立多少个桶如何确定它的区间范围，有很多方法
 * 	我们这里创建的桶数量等于原始数列的元素数量，除了最后一个桶只包含数组最大值，前面各个桶的区间按
 * 	比例确定，区间跨度 = (最大值 - 最小值)/(桶的数量 - 1).
 * 	第二步:遍历原始数组，把元素对号入座放入各个桶中
 * 	第三步：每个桶内的元素分别排序
 * 	第四步：遍历所有的桶，输出所有元素
 *
 */
public class BucketSort {
	
	public static void main(String[] args) {
		Random r = new Random();
		double[] arr = new double[10];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = r.nextDouble();
		}
		System.out.println(Arrays.toString(bucket_Sort(arr)));
	}
	
	public static double[] bucket_Sort(double[] arr) {
		double max = arr[0];
		double min = arr[0];
		//确定最大最小值
		for(double i:arr) {
			if(i<min) min = i;
			if(i>max) max = i;
		}
		//计算桶的数量
		double d = max - min;
		//初始化桶，定义一个LinkList集合表示桶，ArrayList是包含所有桶
		int len = arr.length;
		ArrayList<LinkedList<Double>> arraylist = new ArrayList<LinkedList<Double>>();
		for(int i = 0;i<len;i++) {
			arraylist.add(new LinkedList<Double>());
		}
		//遍历原始数组，将元素放入桶中
		for(int i = 0;i<arr.length;i++) {
			int tmp = (int) ((arr[i] - min) * (len - 1) / d);
			arraylist.get(tmp).add(arr[i]);
		}
		//对每一个桶中元素进行排序
		for(int i = 0;i<arraylist.size();i++) {
			Collections.sort(arraylist.get(i));
		}
		//输出全部元素
		double[] newarr = new double[arr.length];
		int index = 0;
		for(LinkedList<Double> list:arraylist) {
			for(double i : list) 
				newarr[index++] = i;
		}
		return newarr;
	}
	
}
