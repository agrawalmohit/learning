package practice;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> arrayMap = new HashMap<>();
        int[] resultArr = new int[2];
        arrayMap.put(nums[0],0);
        for(int i = 1; i<nums.length; i++){
            int diff = target - nums[i];
            Integer index = arrayMap.get(diff);
            if(null != index){
                resultArr[0] = index.intValue();
                resultArr[1] = i;
                System.out.println(resultArr[0]+" : "+resultArr[1]);
                break;
            }else {
            	arrayMap.put(nums[i], i);
            }
        }
        return resultArr;
    }
	
	public static void main(String[] args) {
		System.out.println(twoSum(new int[] {1,3,5,7,9,2},  5)[0]);
	}
	

}
