//leetcode 3. Longest Substring Without Repeating Characters
//滑动窗口法
class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int[] freq = new int[256];  //存储字符出现次数
        int l = 0, r = -1;
        int res = 0;

        while(l < s.length()) {
            if(r+1 < s.length() && freq[s.charAt(r+1)] == 0) {
                freq[s.charAt(++r)] ++;
            } else {    //r已经到头 || freq[s[r+1]] == 1
                freq[s.charAt(l++)] --;
            }

            res = Math.max(res, r-l+1);
        }
        return res;
    }
}