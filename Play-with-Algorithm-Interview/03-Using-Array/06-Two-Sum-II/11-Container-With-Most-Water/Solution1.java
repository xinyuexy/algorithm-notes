//leetcode 11. Container With Most 

class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }
        
        int l = 0, r = height.length-1;
        int maxArea = 0;
        while (l < r) {
            int cur = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(maxArea, cur);
            if(height[l] < height[r]) {
               l++; 
            } else {
                r--;
            }
        }
        return maxArea;
    }
}