class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPrefix(String exp) {
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char c: exp.toCharArray()){
            if(c=='(') sb.append(')');
            else if(c==')') sb.append('(');
            else sb.append(c);
        }
        
        //reversing the StringBuilder
        sb.reverse();
        
        // converting to postfix
        String postfix = infixToPostfix(reversedExp.toString());
        
        StringBuilder prefix = new StringBuilder(postfix).reverse();
        return prefix.toString();
        
    }
    private static String infixToPostfix(String exp) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (char c : exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop(); // Pop '('
            } else { // Operator
                while (!st.isEmpty() && Prec(c) <= Prec(st.peek())) {
                    sb.append(st.pop());
                }
                st.push(c);
            }
        }
        
        // Pop all the operators from the stack
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        return sb.toString();
    }
    
    private static int Prec(char ch){
        if(ch == '+' && ch=='-') return 1;
        else if(ch == '*' && ch=='/') return 2;
        else if(ch == '^') return 3;
        return -1;
    }
}
