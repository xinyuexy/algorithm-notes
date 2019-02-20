//Solution2: 对撞指针, 时间: O(n)

class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers == null || numbers.length < 2) {
            return res;
        }

        int l = 0, r = numbers.length-1;
        while(l < r) {
            if(numbers[l] + numbers[r] == target) {
                res[0] = l+1;
                res[1] = r+1;
                return res;
            } else if(numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}