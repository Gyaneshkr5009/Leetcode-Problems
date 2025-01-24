class Solution {
    public int characterReplacement(String str, int k) {
         int[] freq=new int[26];
        int l=0;
        int window=0;
        int maxFreq=0;
        for(int r=0; r<str.length();r++){
            freq[str.charAt(r)-'A']++;
            maxFreq=Math.max(maxFreq, freq[str.charAt(r)-'A']);
            while(r-l+1-maxFreq>k){
                freq[str.charAt(l)-'A']--;
                l++;
            }
            window=Math.max(window  ,  r-l+1);
        }
        return window;
    }
}
