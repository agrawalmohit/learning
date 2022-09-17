package practice;

import java.util.HashSet;
import java.util.Set;

public class DuplicateInArray {
	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[] { 1, 2, 4, 5, 6, 7 }));
		System.out.println(containsDuplicate(new int[] { 1, 2, 4, 5, 6, 7, 0 }));
		System.out.println(containsDuplicate(new int[] { 1, 2, 4, 5, 6, 7, 1 }));
		System.out.println(containsDuplicate(new int[] { 1 }));
		System.out.println(containsDuplicate(new int[] { 1, 2, 0, 1 }));
		System.out.println(containsDuplicate(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 1 }));
	}

	public static boolean containsDuplicate(int[] nums) {

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < (nums.length / 2); i++) {
			if (set.add(nums[i]) && set.add(nums[(nums.length / 2)+1 + i])) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}
}
