import java.util.HashMap;
import java.util.Map;

//leetcode 1. Two Sum
//hashmap

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int key = target - nums[i];
            if(map.containsKey(key)) {
                int[] res = {map.get(key), i};
                return res;
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }
}