//leetcode 344. Reverse String

class Solution1 {
    public void reverseString(char[] s) {
        if(s == null || s.length < 2) {
            return;
        }

        int l = 0, r = s.length-1;
        while(l < r) {
            swap(s, l++, r--);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}