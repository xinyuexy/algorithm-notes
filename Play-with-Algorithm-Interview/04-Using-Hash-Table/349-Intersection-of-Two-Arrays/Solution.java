import java.util.HashSet;
import java.util.Set;

//leetcode 349. Intersection of Two Arrays

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums2 == null) {
            return null;
        }

        Set hash1 = new HashSet<Integer>();
        for(int i=0; i<nums1.length; i++) {
            hash1.add(nums1[i]);
        }

        Set<Integer> resSet = new HashSet<Integer>();
        for(int item: nums2) {
            if(hash1.contains(item)) {
                resSet.add(item);
            }
        }

        int[] res = new int[resSet.size()];
        int k = 0;
        for(Integer num: resSet) {
            res[k++] = num;
        }

        return res;
    }
}