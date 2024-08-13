 Time Complexity : O(n)
  Space Complexity : O(n)

***************************************************************************************************************************************
// approach is we have to reverse the postfix to infix (like ( (a+b)*c ) ) conversion problem;
  // so for achieving that we can simply follow some steps;
   //step1: iterate the string and add operands(like a,9,A) to the stack;
   //step2: if we got operator we simply pop() two element from stack as top1 , and top2;
   //step3: add in order[ '(' + top1+ str.charAt(i) +top2 + ')' ],then put new formed String back to Stack;
   //step4: do this until the infix string comes at the top of stack just return st.pop();


class Solution {
    static String postToInfix(String exp) {
        if(exp==null || exp.length() == 0) return "";
        Stack<String> st=new Stack<>();
        String result="";
        for(char c:exp.toCharArray()){
            if(Character.isLetterOrDigit(c)) st.push(String.valueOf(c));
            else{
                String top1=st.pop();
                String top2=st.pop();
                result ='('+top2+c+top1+")";
                st.push(result);
            }
        }
        return st.pop();
    }
}
