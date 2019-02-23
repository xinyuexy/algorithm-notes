import java.awt.List;
//leetcode 15. 3sum
//先排序，然后固定一个数，求剩下两数之和等于target，注意去重

class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            //剪枝:如果当前元素大于0,后面肯定大于0,不可能和等于0了
            if(nums[i] > 0) {   
                break;
            }
            //去重: 和前面元素相等的不必再走一次
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;   //不是break
            }

            int target = 0 - nums[i];
            int l = i+1, r = nums.length-1;
            //有序数组：对撞指针
            while (l < r) {
                if(nums[l] + nums[r] == target) {
                    List<Integer> li = new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[l]);
                    li.add(nums[r]);
                    res.add(li);
                    //继续去重
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++; r--;
                } else if(nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }

            }
        }
        return res;
    }
}