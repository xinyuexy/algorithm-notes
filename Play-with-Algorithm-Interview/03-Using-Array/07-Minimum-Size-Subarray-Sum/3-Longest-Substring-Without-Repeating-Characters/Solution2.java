//leetcode 3. Longest Substring Without Repeating Characters
//滑动窗口法  直接跳到重复位置
class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int l = 0, r = 0;
        int res = 0;

        while(r < s.length()) {     //必须是r, 不能是l(需要判断r是否走到头)
            int index = isDuplicate(s, l, r);
            if(index != -1) {
                l = index + 1;
            } else {
                res = Math.max(res, r-l+1);
                r++;
            }
        }
        return res;
    }

    //判断是否重复,若存在,返回相应的索引, 否则返回-1
    private int isDuplicate(String s, int l, int r) {
        for(int i=l; i<r; i++) {
            if(s.charAt(i) == s.charAt(r)) {
                return i;
            }
        }
        return -1;
    }
}