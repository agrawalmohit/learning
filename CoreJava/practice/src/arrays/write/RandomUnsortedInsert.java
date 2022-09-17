package arrays.write;

/**
 * @author agraw
 * 
 *         To insert an element at random position we need to shift the elements
 *         to the right of requested index
 *
 */
public class RandomUnsortedInsert {

	static boolean insert(int[] arr, int pos, int ele) {
		if (pos < arr.length) {
			// we can insert and last element is lost
			for (int i = arr.length - 1; i > pos; i--) {
				// shifting elements
				arr[i] = arr[i - 1];
			}
			arr[pos] = ele;
		} else {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9};
		if(insert(arr, 5, 11)) {
			for(int i=0;i<arr.length;i++) {
				System.out.printf("%d ",arr[i]);
			}
		}
	}

}
