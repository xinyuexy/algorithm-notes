//leetcode 76. Minimum Window Substring

class Solution1 {
    public String minWindow(String s, String t) {
        //Edge cases
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        //Indicates the number of t characters our sliding window current contains 
        int count = 0;
        //Boundary of Sliding Window
        int left = 0;
        int right = 0;
        //Keep a count (Using ASCII) values of all unfulfilled t characters
        int[] bank = new int[256];
        
        //Keeping track of our min substring which satisfies our "containing all t char" condition
        int min = Integer.MAX_VALUE;
        String minString = "";
        
        //Initialize bank
        for (int i = 0; i < t.length(); i++) {
            bank[t.charAt(i)]++;
        }
        
        while (right < s.length()) {
            //Shift Right Window, if represented index at right pointer is in t (>0), increase count
            if (bank[s.charAt(right++)]-- > 0) {
                count++;
            }
            
            //While our sliding window contains all t characters
            while (count == t.length()) {
                if (min > right - left) {
                    min = right - left;
                    minString = s.substring(left, right);
                }
                
                //Shift our window (Give the string back -> see video for detailed explanation)
                if (++bank[s.charAt(left++)] > 0) {
                    count--;
                }
            }
        }
        return minString;
    }
}