import java.util.ArrayList;
import java.util.HashMap;
//leetcode 350. Intersect
import java.util.Map;ion of Two Arrays II

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) {
            return null;
        }

        Map<Integer,Integer> record = new HashMap<>();
        for(int num: nums1) {
            if(!record.containsKey(num)) {
                record.put(num, 1);
            } else {
                record.put(num, record.get(num)+1);
            }
        }

        List<Integer> li = new ArrayList<>();
        for(int num: nums2) {
            if(record.containsKey(num) && record.get(num) > 0) {
                li.add(num);
                record.put(num, record.get(num)-1);
            }
        }

        int[] res = new int[li.size()];
        int index = 0;
        for(int num: li) {
            res[index++] = num;
        }

        return res;
    }
}