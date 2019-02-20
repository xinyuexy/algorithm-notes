//leetcode 27. Remove Element
//优化: 不需要交换，只需要保证不等于val的在最前面
class Solution3 {
    public int removeElement(int[] nums, int val) {
        if(nums == null) {
            return 0;
        }
        //把不等于val的交换到前面
        int k = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                //优化: 不需要交换,只需要保证不等于val的在最前面
                if(i != k) {
                    nums[k++] = nums[i];
                } else {
                    k++;
                }
            }
        }

        return k;
    }
}