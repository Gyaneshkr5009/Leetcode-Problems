//time and space complexity both  : O(n)

//***************************************************(2nd approach)************************************************************************************

class Solution {
    public int longestValidParentheses(String s) {
        if(s==null || s.length()==0) return 0;
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int length=0;
        for(int i=0 ;i< s.length() ;i++){
            if(s.charAt(i)=='(') st.push(i);
            else{
                st.pop();
                if(st.isEmpty()) st.push(i);
                else length=Math.max(length , i-st.peek());
            }
        }
        return length;
    }
}

//**********************************************************(1st approach -> brute force)****************************************************************************
//time complexity : O(n*n);
// space complexity :O(n*n);

class Solution {
    public int longestValidParentheses(String s) {
        if(s==null || s.length()==0) return 0;
        int window=0;
        for(int i=0 ;i< s.length() ;i++){
            for(int j=i+1; j<s.length() ;j+=2){
                if (checkParantheses(s, i, j)) {
                    window = Math.max(window, j - i + 1);
                }
            }
        }
        return window;
    }
    private boolean checkParantheses(String s,int left , int right ){
        Stack<Character> st=new Stack<>();
        for(int i=left ; i<= right ;i++){
            char ch=s.charAt(i);
            if(ch=='(') st.push(')');
            else if(st.isEmpty() || st.pop()!=ch) return false;
        }
        return st.isEmpty();
    }
}
