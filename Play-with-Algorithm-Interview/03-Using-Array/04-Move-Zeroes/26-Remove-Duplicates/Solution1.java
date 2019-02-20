//leetcode 26. Remove Duplicates from Sorted Array

class Solution1 {
    public int removeDuplicates(int[] nums) {
        if(nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }

        int k = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k+1;
    }
}