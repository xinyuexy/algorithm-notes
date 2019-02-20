//leetcode 209. Minimum Size Subarray Sum
//滑动窗口, O(n)

class Solution1 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length+1;
        while(l < nums.length) {
            if(r+1 < nums.length && sum < s) {
                sum += nums[++r];
            } else {    // r已经到头 或者 sum >= s
                sum -= nums[l++];
            }

            if(sum >= s)
                res = Math.min(res, r - l + 1);
        }

        if(res == nums.length+1) {
            return 0;
        }
        return res;
    }
}