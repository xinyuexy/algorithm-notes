//leetcode 27. Remove Element
class Solution4 {
    public int removeElement(int[] nums, int val) {
        if(nums == null) {
            return 0;
        }
        
        int l = 0, r = nums.length-1;
        while(l <= r) {
            if(nums[l] == val) {
                nums[l] = nums[r--];
            } else {
                l++;
            }
        }
        return l;
    }
}