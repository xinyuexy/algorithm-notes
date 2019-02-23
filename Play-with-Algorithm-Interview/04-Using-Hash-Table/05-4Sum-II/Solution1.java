//leetcode 454. 4Sum II
//时间: O(n^2)
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A==null || B==null || C==null || D==null) {
            return 0;
        }

        Map<Integer,Integer> map = new HashMap<>();
        //存储C[k]+D[l]的所有组合
        for(int k=0; i<C.length; k++) {
            for(int l=0; j<D.length; l++) {
                if(!map.containsKey(C[k]+D[l])) {
                    map.put(C[k]+D[l], 1);
                } else {
                    map.put(C[k]+D[l], map.get(C[k]+D[l])+1);
                }
            }
        }

        int count = 0;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                int target = 0-A[i]-B[j];
                // if(map.containsKey(target) && map.get(target) > 0) {
                //     count++;
                //     map.put(target, map.get(target)--);
                // }
                if(map.containsKey(target)) {
                    //加上所有C[k]+D[l]的和为target的数目
                    count += map.get(target);
                }
            }
        }

        return count;
    }
}