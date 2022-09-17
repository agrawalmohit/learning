package arrays.write;

import java.util.Arrays;

/**
 * @author agraw
 *
 *         If we delete from random position; then we need to shift the array
 *         left towards the deleted position element
 */
public class RandomUnsortedDelete {

	static int delete(int[] arr, int pos) {
		if (pos < arr.length) {
			int deletedElement = arr[pos];
			for (int i = pos; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			arr[arr.length - 1] = 0;
			Arrays.stream(arr).forEach(e -> System.out.printf("%d ", e));
			System.out.println();
			return deletedElement;
		} else {
			throw new RuntimeException("position out of bounds");
		}
	}

	public static void main(String[] args) {
		System.out.println(delete(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 4));
	}
}
