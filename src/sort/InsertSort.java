package sort;

import java.util.ArrayList;
import java.util.List;

public class InsertSort {
	public static void insertSort() {
		int a[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51,1};
		int temp = 0;
		for(int i=1;i<a.length;i++) {
			int j = i - 1;
			temp = a[i];
			for(;j>=0&&temp<a[j];j--) {
				a[j+1]=a[j];
			}
			a[j+1]=temp;
		}
		printArr(a);
	}
	
	public static void shellSort(){
		int a[] = {34,1,54,6,3,78,12,45,56,100};
		double d1 = a.length;
		int temp = 0;
		while(true){
			d1 = Math.ceil(d1/2);//向上取整计算
			int d = (int)d1;
			for(int x=0;x<d;x++) {
				for(int i=x+d;i<a.length;i+=d){
					int j=i-d;
					temp = a[i];
					for(;j>=0&&temp<a[j];j-=d) {
						a[j+d] = a[j];
					}
					a[j+d] = temp;
				}
			}
			if(d == 1){
				break;
			}
		}
		printArr(a);
	}
	
	public static void selectSort(){
		int a[] = {190,1,54,6,3,78,34,12,45};
		int position = 0;
		for(int i=0;i<a.length;i++){
			int j=i+1;
			position = i;
			int temp = a[i];
			for(;j<a.length;j++){
				if(a[j] < temp) {
					temp = a[j];
					position = j;
				}
			}
			a[position] = a[i];
			a[i] = temp;
		}
		printArr(a);
	}
	
	public static void HeapSort(){
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,0,4,62,99,98,-12,54,56,17,18,23,34,15,35,25,53,51}; 
		int arrayLength = a.length;
		//循环建堆
		for(int i=0;i<arrayLength-1;i++) {
			//建堆
			buildMaxHeap(a,arrayLength-1-i);
			//交换堆顶和最后一个元素
			swap(a,0,arrayLength-1-i);
		}
		printArr(a);
	}
	
	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	//对a数组从0到lastIndex建大顶堆
	private static void buildMaxHeap(int[] a, int lastIndex) {
		//从lastIndex处节点（最后一个节点）的父节点开始 
		for(int i=(lastIndex-1)/2;i>=0;i--){
			//k保存正在判断的节点
			int k = i;
			//如果当前k节点的子节点存在
			while(k*2+1 <= lastIndex){
				//k节点的左子节点的索引
				int biggerIndex = 2*k+1;
				//如果biggerIndex小于lastIndex,即biggerIndex+1代表的k节点的右子节点存在
				if(biggerIndex<lastIndex){
					//如果右子节点的值较大
					if(a[biggerIndex] < a[biggerIndex+1]) {
						//biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				//如果k节点的值小于其较大的子节点的值
				if(a[k] < a[biggerIndex]) {
					//交换它们
					swap(a,k,biggerIndex);
					//将biggerIndex赋予k,开始while循环的下一次循环,重新保证k节点的值大于其左右子节点的
					k = biggerIndex;
				}else {
					break;
				}
			}
		}
	}

	public static void bubbleSort(){
		int a[]={49,38,65,97,76,13,27,49,78,34,-12,64,5,4,62,99,98,54,56,0,17,18,23,34,15,35,25,53,51}; 
		int temp = 0;
		for(int i=0;i<a.length-1;i++) {
			for(int j=0;j<a.length-1-i;j++){
				if(a[j] > a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		printArr(a);
	}
	
	public static void quickSort(){
		int a[]={49,38,65,97,76,13,27,49,78,34,-12,64,5,4,62,99,98,54,56,1,0,7,18,23,34,15,35,25,53,51};
		if(a.length > 0) {
			_quickSort(a,0,a.length-1);
		}
		printArr(a);
	}
	
	private static void _quickSort(int[] a, int low, int high) {
		if(low < high) {
			int middle = getMiddle(a,low,high);//将a数组进行一份为二
			_quickSort(a,low,middle - 1);//对低字表进行递归排序
			_quickSort(a,middle +1,high);//对高字表进行递归排序
		}
	}

	private static int getMiddle(int[] a, int low, int high) {
		int tmp = a[low];
		while(low < high) {
			while(low < high && a[high] >= tmp) {
				high--;
			}
			a[low] = a[high];//比中轴小的记录移到低端
			while(low < high && a[low] <= tmp) {
				low++;
			}
			a[high] = a[low];////比中轴大的记录移到高端
		}
		a[low] = tmp;//中轴记录到尾 
		return low;//返回中轴的位置
	}

	public static void mergingSort(){
		int a[]={49,38,65,97,76,13,27,49,78,0,11,34,12,64,5,4,-62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		sort(a,0,a.length-1);
		printArr(a);
	}
	private static void sort(int[] a, int left, int right) {
		if(left < right) {
			//找出中间索引
			int center = (left + right) / 2;
			//对左边数组进行递归
			sort(a,left,center);
			//对右边数组进行递归
			sort(a,center+1,right);
			//合并
			merge(a,left,center,right);
		}
	}

	private static void merge(int[] a, int left, int center, int right) {
		int[] tmpArr = new int[a.length];
		int mid = center + 1;
		//third记录中间数组的索引
		int third = left;
		int tmp = left;
		while(left <= center && mid <= right) {
			//从两个数组中取出最小的放入中间数组
			if(a[left] <= a[mid]) {
				tmpArr[third++] = a[left++];
			}else {
				tmpArr[third++] = a[mid++];
			}
		}
		//剩余部分依次放入中间数组
		while(mid <= right) {
			tmpArr[third++] = a[mid++];
		}
		while(left <= center) {
			tmpArr[third++] = a[left++];
		}
		//将中间数组中的内容复制回原数组
		while(tmp <= right){
			a[tmp] = tmpArr[tmp++];
		}
	}

	public static void radixSort(){
		int a[]={49,38,65,97,76,13,2,7,49,78,3,4,12,64,0,11,5,4,62,99,98,54,101,56,17,18,23,34,15,35,25,53,51}; 
		sort(a);
		printArr(a);
	}

	private static void sort(int[] a) {
		//首先确定排序的趟数
		int max = a[0];
		for(int i=1;i<a.length;i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		int time = 0;
		//判断位数
		while(max > 0) {
			max /= 10;
			time++;
		}
		//建立10个列队
		List<ArrayList> queue = new ArrayList<ArrayList>();
		for(int i=0;i<10;i++) {
			ArrayList<Integer> queue1 = new ArrayList<Integer>();
			queue.add(queue1);
		}
		//进行time次分配和收集
		for(int i=0;i<time;i++) {
			//分配数组元素
			for(int j = 0;j<a.length;j++) {
				//得到数字的第time+1位数
				int x = Math.abs(a[j] % (int)Math.pow(10, i+1)/(int)Math.pow(10, i)); //正整数
				ArrayList<Integer> queue2 = queue.get(x);
				queue2.add(a[j]);
				queue.set(x,queue2);
			}
			int count = 0;//元素计数器
			//收集队列元素
			for(int k = 0;k<10;k++) {
				while(queue.get(k).size() >0) {
					ArrayList<Integer> queue3 = queue.get(k);
					a[count] = queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
		}
	}

	private static void printArr(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]); 
		}
	}
	
	public static void main(String[] args) {
//		InsertSort.insertSort();
//		InsertSort.shellSort();
//		InsertSort.selectSort();
//		InsertSort.HeapSort();
//		InsertSort.bubbleSort();
//		InsertSort.quickSort();
//		InsertSort.mergingSort();
		InsertSort.radixSort();
	}
}
