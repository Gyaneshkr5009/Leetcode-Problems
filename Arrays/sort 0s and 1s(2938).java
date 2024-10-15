//time complexity:O(n);
//space complexity:O(1);
//*******************************************************************************************************************************************************
class Solution {
    public long minimumSteps(String s) {
        // we iterate through string and when we encounter 0 then we have to move 0 upto n times we encounter 1 by incrementing black++;
        int white =0 , black=0;
        long cnt=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='1') black++;
            if(ch=='0'){
                cnt+=black;
            }
        }
        return cnt;
    }
}
