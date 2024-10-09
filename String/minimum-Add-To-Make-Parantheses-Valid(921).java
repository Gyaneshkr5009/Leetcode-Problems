time complexity:O(n);
space complexity:O(1);
//******************************************************************************************************************
class Solution {
    public int minAddToMakeValid(String s) {
        int openBr=0 , closeBr=0;

        for(char c:s.toCharArray()){
            if(c=='(') openBr++;
            else if(c==')' && openBr>0) openBr--;
            else closeBr++;
        }
        return openBr+closeBr;
    }
}
