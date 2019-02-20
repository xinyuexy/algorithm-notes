//leetcode 215. Kth Largest Element in an Array

class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null) {
            return -1;
        }
        if(nums.length == 1) {
            return nums[0];
        }

        int l = 0, r = nums.length - 1;
        int target = nums.length - k;   //partition目标值
        while(l <= r) {
            int i = partition(nums, l, r);
            if(i == target) {
                return nums[i];
            } else if(i < target) {
                l = i+1;
                // target = target - i - 1;     //taget不用变,因为l不是从0开始的
            } else {
                r = i-1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i = l;
        for(int j=l+1; j<=r; j++) {
            if(nums[j] < pivot) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i, l);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}