package practice;

public class BinarySearch {
	
	public static void main(String[] args) throws InterruptedException {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		int[] arr6 = new int[] {1,2,3,4,5,6,7,8};
		int[] arr2 = new int[] {1};
		binarySearch(arr, 1);
		binarySearch(arr, 0);
		binarySearch(arr, 5);
		binarySearch(arr, 4);
		binarySearch(arr, 9);
		binarySearch(arr, 8);
		binarySearch(arr, 6);
		binarySearch(arr6, 0);
		binarySearch(arr6, 1);
		binarySearch(arr6, 4);
		binarySearch(arr6, 5);
		binarySearch(arr6, 7);
		binarySearch(arr6, 8);
	}
	
	public static void binarySearch(int[] arr, int ele) throws InterruptedException {
		int begin = 0;
		int end = arr.length;
		boolean notFound = true;
		while(end>=begin) {
			int searchIdx = begin+(end-begin)/2;
			if(ele==arr[searchIdx]) {
				System.out.println("element "+ele+" found at "+searchIdx);
				notFound=false;
				break;
			}
			if(ele>arr[searchIdx]) {
				begin = searchIdx+1;
			}
			if(ele<arr[searchIdx]) {
				end = searchIdx-1;
			}
		}
		if(notFound) {
			System.out.println("element "+ele+" not found");
		}
	}

}
