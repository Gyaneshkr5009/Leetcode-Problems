  Time Complexity : O(n)
  Space Complexity : O(n)

***************************************************************************************************************************************
//approach is that we push lettersOrdigit into Stack  , after countring an operator we will pull out last two element from stack merge with character(c) and put back to stack
// doing this until we iterate whole string ,end of the day we got the result as String as as answer;
    
class Solution {
    static String postToPre(String s) {
        if(s == null || s.length() == 0) return "";
        Stack<String> st=new Stack<>();
        String result="";
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c)) st.push(String.valueOf(c));
            else{
                String top1=st.pop();
                String top2=st.pop();
                result=c+top2+top1;
                st.push(result);
            }
        }
        return st.pop();
    }
}
