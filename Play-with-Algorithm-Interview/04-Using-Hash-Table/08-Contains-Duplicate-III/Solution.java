//leetcode 220. Contains Duplicate III
//使用查找表的顺序性(TreeSet)

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2) {
            return false;
        }
        // 这个问题的测试数据在使用int进行加减运算时会溢出
        // 所以使用long
        TreeSet<Long> record = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            //ceiling返回大于等于指定元素的第一个
            //abs(nums[i] - nums[j]) <= t
            //nums[i]-t <= nums[j] <= nums[i]+t
            if(record.ceiling((long)nums[i]-(long)t) != null && 
                record.ceiling((long)nums[i]-(long)t) <= (long)nums[i] + (long)t) {
                return true;
            }
            record.add((long)nums[i]);
            if(record.size() == k + 1)
                record.remove((long)nums[i-k]);
        }
        return false;
    }
}