package learning.arrayRotation;

public class RotateArraytTest {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		System.out.print("Actual array: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		// countOfElementsToRotate must be lest than size of array
		int[] rotatedArray = rotateArray(arr, arr.length, 3);
		System.out.print("\nRotated array: ");
		for (int i = 0; i < rotatedArray.length; i++) {
			System.out.print(rotatedArray[i] + " ");
		}

	}

	public static int[] rotateArray(int[] arrayToRotate, int arraySize, int countOfElementsToRotate) {
		int[] temp = new int[arraySize];
		int j = 0;
		for (int i = arraySize - countOfElementsToRotate; i < arraySize; i++, j++) {
			temp[j] = arrayToRotate[i];
		}
		for (int i = 0; i < arraySize - countOfElementsToRotate; i++, j++) {
			temp[j] = arrayToRotate[i];
		}
		return temp;
	}

}
