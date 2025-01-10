//time complexity:O(n);
//space complexity:O(1);
//*************************************************************************************************************************
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length() || s.length()<2) return false;
        if(s.equals(goal)){
            int[] freq=new int[26];
            for(char ch:s.toCharArray()){
                freq[ch-'a']++;
                //as if we got a char with two or more freq we can swap them to produce same result;
                if(freq[ch-'a']>=2) return true;
            }
            return false;
        }
        //for not equals string;
        int i=-1,j=-1 , count=0;
        for(int idx=0;idx<s.length();idx++){
            if(s.charAt(idx)!=goal.charAt(idx)){
                if(i==-1) i=idx;
                if(i!=-1) j=idx;
                count++;
                if(count>2) return false;
            }
        }
        if((i!=-1 && j==-1)) return false;
        return s.charAt(i)==goal.charAt(j);
    }
}
