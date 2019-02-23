//leetcode 49. Group Anagrams
//参考:https://leetcode.com/problems/group-anagrams/solution/
class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null) {
            return new ArrayList();
        }

        Map<String, List> ans = new HashMap<>();
        for(String str: strs) {
            char[] ca = str.toCharArray();
            //排序:以排序后的string作为key
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            } 
            ans.get(key).add(str);
        }

        return new ArrayList(ans.values());
    }
}