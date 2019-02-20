//leetcode 345. Reverse Vowels of a String

class Solution1 {
    public String reverseVowels(String s) {
        if(s == null || s.length() < 2) {
            return s;
        }

        char[] arr = s.toCharArray();
        int l = 0, r = arr.length-1;
        while(l < r) {
            if(!isVowel(arr[l])) {
                l++;
                continue;
            }
            if(!isVowel(arr[r])) {
                r--;
                continue;
            }
            swap(arr, l++, r--);
        }

        return String.valueOf(arr);
    }

    private boolean isVowel(char c) {
        char ch = Character.toLowerCase(c);
        switch(ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}