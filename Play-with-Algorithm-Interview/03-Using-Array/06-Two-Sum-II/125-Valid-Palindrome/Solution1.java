//leetcode 125. Valid Palindrome
//对撞指针

class Solution1 {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() < 2) {
            return true;
        }

        //去除空格并转换为小写
        String str = s.replaceAll(" ", "").toLowerCase();

        int l = 0, r = str.length()-1;
        while(l < r) {
            char chl = str.charAt(l);
            char chr = str.charAt(r);
            if(!Character.isLetterOrDigit(chl)) {
                l++;
                continue;
            } 
            if(!Character.isLetterOrDigit(chr)) {
                r--;
                continue;
            }
            if(chl != chr) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}