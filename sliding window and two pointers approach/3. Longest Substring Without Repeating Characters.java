class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int window=0;
        HashSet<Character> ans=new HashSet<>();
        while(right < s.length()){
            if(!ans.contains(s.charAt(right))){
                ans.add(s.charAt(right));
                window=Math.max(window , ans.size());
                right++;
            }
            else{
                ans.remove(Character.valueOf(s.charAt(left)));
                left++;
            }
        }
        return window;
    }
}
