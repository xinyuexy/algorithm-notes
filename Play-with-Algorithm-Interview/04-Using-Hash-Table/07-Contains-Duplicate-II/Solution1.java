//leetcode 219. Contains Duplicate II
//4-7 查找表和滑动窗口 Contain Duplicate II

class Solution1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2) {
            return false;
        }
        //record记录滑动窗口中的元素
        Set<Integer> record = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(record.contains(nums[i])) {
                return true;
            }
            record.add(nums[i]);
            if(record.size() == k+1) {
                record.remove(nums[i-k]);
            }
        }

        return false;
    }
}