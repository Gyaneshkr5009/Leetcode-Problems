  Time Complexity : O(n)
  Space Complexity : O(n)
***********************************************************************************************************************************************
class Solution {
    public String removeKdigits(String num, int k) {
        //Declaring a Stack to store char elements;
        Stack<Character> st=new Stack<>();
        if(k>=num.length()) return "0"; // if k>=0 means it says remove all element;
        for(char n:num.toCharArray()){
            //if top st element > n ,means min number can be formed by replacing it with min value;
            while(!st.isEmpty() && k>0 && st.peek() > n){
                st.pop();
                k--;
            }
            st.push(n);
        }
        // Remove remaining k digits from the end of the stack
        while(k>0){
            st.pop();
            k--;
        }
        // Construct the resulting string from the stack
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        //reversing the StringBuilder;
        sb.reverse();

        //removing all zeroes from the strt | this loop ensures if we get string like "0000";
        while(sb.length()>0 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        //returning sb as string using .toString() fuctn;
        return sb.length()==0 ? "0" : sb.toString();
    }
}
