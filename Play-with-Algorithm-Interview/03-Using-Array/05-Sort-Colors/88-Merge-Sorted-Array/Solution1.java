//leetcode 88. Merge Sorted Array
//从后往前遍历
class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1==null || nums2 == null || nums1.length==0 || nums2.length==0) {
            return;
        }

        int r1 = m+n-1;
        int p1 = m-1, p2 = n-1;
        while(p1 >= 0 && p2 >= 0) {
            if(nums1[p1] < nums2[p2]) {
                nums1[r1--] = nums2[p2--];
            } else {
                nums1[r1--] = nums1[p1--];
            }
        }
        while(p2 >= 0) {
            nums1[r1--] = nums2[p2--];
        }
    }
}