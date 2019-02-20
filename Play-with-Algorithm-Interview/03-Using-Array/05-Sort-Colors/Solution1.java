//3-5 三路快排partition思路的应用 Sort Color
// 计数排序的思路
// 对整个数组遍历了两遍
// 时间复杂度: O(n)
// 空间复杂度: O(k), k为元素的取值范围
class Solution1 {
    public void sortColors(int[] nums) {
        int[] count = {0, 0, 0};   // 存放0, 1, 2三个元素的频率
        for(int i=0; i<nums.length; i++) {
            count[nums[i]]++;
        }

        int index = 0;
        for(int i=0; i<count[0]; i++) {
            nums[index++] = 0;
        }
        for(int i=0; i<count[1]; i++) {
            nums[index++] = 1;
        }
        for(int i=0; i<count[2]; i++) {
            nums[index++] = 2;
        }
    }
}