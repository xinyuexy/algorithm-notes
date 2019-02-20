//优化: 使用快速排序中的三路划分
//参考: https://www.imooc.com/article/16141

class Solution2 {
    public void sortColors(int[] nums) {
        int lt = -1;    // nums[0...lt] < v
        int gt = nums.length;   //nums[gt...r] > v
        int i = 0;              //nums[lt+1...i) = v;
        while(i < gt) {
            if(nums[i] == 1) {
                i++;
            } else if(nums[i] == 2) {
                swap(nums, i, --gt);
            } else {
                swap(nums, i++, ++lt);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}