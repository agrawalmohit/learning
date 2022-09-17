package practice;

public class MaxSumContSubarray {

	public static int maxSubArray(int[] nums) {

		int currentMaxSum = Integer.MIN_VALUE;
		int begPointer = 0;
		int start = 0;
		int end = 0;
		int maxNow = 0;
		for (int i = 0; i < nums.length; i++) {
			maxNow = maxNow + nums[i];
			if (currentMaxSum < maxNow) {
				currentMaxSum = maxNow;
				end = i;
				start = begPointer;
			}
			if (maxNow < 0) {
				// reset max
				maxNow = 0;
				begPointer = i + 1;
			}
		}
		System.out.println("Start:"+start+" end:"+end);
		return currentMaxSum;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-1,-2,-3,-4,-5}));
	}
}
