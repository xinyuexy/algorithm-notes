//更简洁, 知道数字和字母对应的ASCII码
class Solution2 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) return true;
        
        for (int i = 0, j = s.length() -1; i < j; ) {
            if (normalizeChar(s.charAt(i)) == ' ') i++;
            else if (normalizeChar(s.charAt(j)) == ' ') j--;
            else if (normalizeChar(s.charAt(i++)) != normalizeChar(s.charAt(j--)))
                return false;
        }
        
        return true;
    }
    
    private char normalizeChar(char c) {
        if (c > 96 && c < 123 || c > 47 && c < 58) return c;
        if (c > 64 && c < 91) return c += 32;
        return ' ';
    }
}