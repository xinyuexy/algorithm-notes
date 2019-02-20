//leetcode 80. Remove Duplicates from Sorted Array II
// 重点掌握: 主要把逻辑理顺, 不能想当然
class Solution1 {
    public int removeDuplicates(int[] nums) {
        if(nums==null) {
            return 0;
        }
        if(nums.length <= 2) {
            return nums.length;
        }

        int k = 0, count = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[k]) {
                nums[++k] = nums[i];
                count = 1;
            }
            else if(count < 2) {
                nums[++k] = nums[i];
                count++;
            }
        }
        
        return k+1;
    }
}