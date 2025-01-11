//time complexity:O(n);
//space complexity:O(1);
//*****************************************************************************************************************************************
class Solution {
    public boolean canConstruct(String s, int k) {
        int n=s.length();
        if(s==null || n==0 || n<k) return false;
        if(n==k) return true;
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        int oddCount=0;
        for(int i:freq){
            if(i%2==1) oddCount++;
            if(oddCount>k) return false;
        }

        return true;
    }
}
