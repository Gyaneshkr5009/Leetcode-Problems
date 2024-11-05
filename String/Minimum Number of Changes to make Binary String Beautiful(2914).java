//time complexity:O(n) 
//space complexity:O(1)
//*********************************************************************************************************************************
//iterating two steps to chaeck for the string in even substring;
class Solution {
    public int minChanges(String s) {
        if(s==null ||  s.length() == 0) return 0;

        int changes=0;
        for(int i=0 ;i < s.length() ; i+=2){
            if(s.charAt(i) != s.charAt(i+1)) changes++;
        }

        return changes;
    }
}
