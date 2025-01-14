/*
    Worst Case: O(N * K)

    Where:
        N is the length of the input string s.
        K is the maximum number of repetitions for any encoded substring.
*/
//**************************************************(Stack && StringBuilder)********************************************
class Solution {
    public String decodeString(String s) {
        int n=s.length();
        if(s==null || n==0) return "";

        Stack<String> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch==']'){
                StringBuilder sb=new StringBuilder();
                while(!st.isEmpty() && !st.peek().equals("[")){
                    sb.insert(0 , st.pop());
                }
                st.pop(); //for removing '[';

                //for getting the repeat count ;
                StringBuilder numBuilder = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                    numBuilder.insert(0, st.pop());
                }

                int value=Integer.parseInt(numBuilder.toString()); //for k value;

                st.push(sb.toString()); // pushing reverse of sb;
                for(int j=1 ;j<value ;j++){
                    sb.append(st.peek());
                }
                st.pop();
                //pushing back to st;
                st.push(sb.toString());
            }
            else {
                st.push(Character.toString(ch));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.insert(0, st.pop());
        }
        return result.toString();
    }
}
