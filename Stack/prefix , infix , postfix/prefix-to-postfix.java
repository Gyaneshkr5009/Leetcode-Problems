 Time Complexity : O(n)
  Space Complexity : O(n)

***************************************************************************************************************************************
// approach is we have to reverse the pretfix to postfix conversion problem;
  // so for achieving that we can simply follow some steps;
   //step1: iterate from the last of string and add operands(like a,9,A) to the stack;
   //step2: if we got operator we simply pop() two element from stack as top1 , and top2;
   //step3: add in order top1 +top2 + str.charAt(i) ,then put new formed String back to Stack;
   //step4: do this until the postfix string comes at the top of stack just return st.pop();

class Solution {
    static String preToPost(String s) {
        if(s==null || s.length() == 0) return "";
        Stack<String> st=new Stack<>();
        String result="";
        for(int i=s.length()-1 ; i>=0  ; i--){
            char c=s.charAt(i);
            if(Character.isLetterOrDigit(c)) st.push(String.valueOf(c));
            else{
                String top1=st.pop();
                String top2=st.pop();
                result=top1+top2+c;
                st.push(result);
            }
        }
        return st.pop();
    }
}
