//leetcode 167. Two Sum II - Input array is sorted
//Solution1: 二分查找target-i, 时间: O(nlogn)
class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers == null || numbers.length < 2) {
            return res;
        }

        for(int i=0; i<numbers.length-1; i++) {
            int index = binarySearch(numbers, i+1, target-numbers[i]);
            if(index != -1) {
                res[0] = i+1;
                res[1] = index+1;
            }
        }

        return res;
    }

    private int binarySearch(int[] numbers, int start, int key) {
        int l = start, r = numbers.length-1;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(numbers[mid] == key) {
                return mid;
            } else if(numbers[mid] < key) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return -1;
    }
}