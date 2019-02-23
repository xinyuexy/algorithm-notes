import java.util.Arrays;

//leetcode 18. 4Sum

class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);

        //优化:target太小或太大都不行
        int max = nums[nums.length - 1];
		if (4 * nums[0] > target || 4 * max < target)
			return res;

        for(int i=0; i<nums.length-3; i++) {
            //去重
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1; j<nums.length-2; j++) {
                //去重
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                
                int l = j+1, r = nums.length-1;
                while(l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target) {
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        //去重
                        while(l < r && nums[l] == nums[l+1])  
                            l++;
                        while(l < r && nums[r] == nums[r-1])
                            r--;
                        l++; r--;
                    } else if(sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return res;
    }
}