import java.util.Arrays;

//leetcode 16. 3Sum Closest

class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return 0;
        }
        if(nums.length == 3) {
            return nums[0]+nums[1]+nums[2];
        }

        Arrays.sort(nums);

        int minSum = nums[0] + nums[1] + nums[2];
        if(target <= minSum) {
            return minSum;
        }
        int len = nums.length;
        int maxSum = nums[len-3] + nums[len-2] + nums[len-1];
        if(target >= maxSum) {
            return maxSum;
        }

        int diff = Integer.MAX_VALUE;
        System.out.println(diff);
        int res = 0;
        for(int i=0; i<nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i+1, r = nums.length-1;
            //优化
            if(nums[i] + nums[r-1] + nums[r] < target) {
                if(diff > Math.abs(target-nums[i]-nums[r-1]-nums[r])) {
                    res = nums[i] + nums[r-1] + nums[r];
                    diff = Math.abs(target-nums[i]-nums[r-1]-nums[r]);
                }
                continue;
            }
            if(nums[i] + nums[l] + nums[l+1] > target) {
                if(diff > Math.abs(target-nums[i]-nums[l]-nums[l+1])) {
                    res = nums[i] + nums[l] + nums[l+1];
                    diff = Math.abs(target-nums[i]-nums[l]-nums[l+1]);
                }
                continue;
            }
            
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(diff > Math.abs(target-sum)) {
                    diff = Math.abs(target-sum);
                    res = sum;
                }
                if(sum == target) {
                    return sum;
                } else if(sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}