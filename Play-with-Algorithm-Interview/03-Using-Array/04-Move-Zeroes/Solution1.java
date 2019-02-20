//leetcode 283. Move Zeroes
//时间复杂度: O(n), 空间:O(1)
//思路: 遍历数组,将非0元素交换到最前面
class Solution1 {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }

        int k = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                //如果前面一直是非0元素,会一直和自己交换,可以进一步优化
                if(i != k) {
                    swap(nums, i, k++);
                } else {
                    k++;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0,1,0,3,1};
        new Solution1().moveZeroes(array);
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}