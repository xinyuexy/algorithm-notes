//leetcode 27. Remove Element
//优化: 不和自身交换
class Solution2 {
    public int removeElement(int[] nums, int val) {
        if(nums == null) {
            return 0;
        }
        //把不等于val的交换到前面
        int k = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                //优化: 不和自身交换
                if(i != k) {
                    swap(nums, i, k++);
                } else {
                    k++;
                }
            }
        }

        return k;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}