//time complexity:O(n);
//space comlexity:O(1);

//approach:=> depth is calculated by number of expressions inside nested brackets where n nested brackets = n depth ,condition also having closing one in right order;
//************************************************(optimal approach)****************************************************************
class Solution {
    public int maxDepth(String s) {
        int depth=0;
        int openBr=0;
        for(char c:s.toCharArray()){
            if(c=='(') openBr++;
            else if(c==')' && openBr>0) openBr--;
            depth=Math.max(depth , openBr);
        }
        return depth;
    }
}

//***************************************************(brute force using stack)****************************************************
//time complexity:O(n);
//space comlexity:O(n);

class Solution {
    public int maxDepth(String s) {
        int depth=0;
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(') st.push(c);
            else if(c==')' && st.peek()=='(') st.pop();
            depth=Math.max(depth , st.size());
        }
        return depth;
    }
}
