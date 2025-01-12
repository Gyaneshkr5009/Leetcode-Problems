//*************************************************(most optimized approach)****************************************************

class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2==1) return false;
        Stack<Integer> open=new Stack<>();
        Stack<Integer> openclose=new Stack<>();
        for(int i =0;i<s.length();i++){
            if(locked.charAt(i)=='0'){
                openclose.push(i);
            }
            else if(s.charAt(i)=='('){
                open.push(i);
            }
            else if(s.charAt(i)==')'){
                if(!open.isEmpty()){
                    open.pop();
                }
                else if(!openclose.isEmpty()){
                    openclose.pop();
                }
                else return false;
            }
        }
        while(!open.isEmpty() && !openclose.isEmpty() && open.peek() < openclose.peek()){
            open.pop();
            openclose.pop();
        }
        return open.isEmpty();
    }
}

//***************************************************************************************(brute force)***********************************************
class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2==1) return false;
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        if(helper(s, locked , 0 , sb, n)) return true;
        return false;
    }
    private boolean helper(String s, String locked , int idx , StringBuilder sb ,int n){
        if(idx==n){
            if(isValid(sb)) return true;
            else return false;
        }
        if(locked.charAt(idx)=='1') sb.append(locked.charAt(idx++));
        if(helper(s,locked , idx+1 , sb.append('(') , n)) return true;
        if(helper(s, locked , idx+1 , sb.append(')') , n)) return true;
        return false;
    }
    private boolean isValid(StringBuilder sb){
        int countA=0 , countB=0;
        for(char ch:sb.toString().toCharArray()){
            if(ch=='(') countA++;
            if(ch==')'){
                if(countA>0) countA--;
                else countB++;
            }
        }
        if(countA>0 || countB>0) return false;
        return true;
    }
}
//***************************************************************(optimized)**************************************************************
class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2==1) return false;
        return helper(s, locked, 0, 0, 0);
    }
    private boolean helper(String s, String locked, int idx, int open, int close) {
        if (close > open) return false; 
        if (idx == s.length()) return open == close; 

        char current = s.charAt(idx);
        if (locked.charAt(idx) == '1') {
            if (current == '(') return helper(s, locked, idx + 1, open + 1, close);
            else return helper(s, locked, idx + 1, open, close + 1);
        } else {
            return helper(s, locked, idx + 1, open + 1, close) || helper(s, locked, idx + 1, open, close + 1);
        }
    }
}

//********************************************************************(dp approach)*********************************************************
class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s==null || s.length()==0) return false;
        int n=s.length();
        if(n%2==1) return false;
        boolean[][] dp=new boolean[n+1][n+1];
        dp[0][0]=true;

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            boolean isLocked= locked.charAt(i)=='1';
            for(int balance=0;balance<=n/2;balance++){
                if(!dp[i][balance]) continue;

                if(isLocked){
                    if (ch == '(' && balance + 1 <= n / 2) {
                        dp[i + 1][balance + 1] = true;
                    } else if (ch == ')' && balance > 0) {
                        dp[i + 1][balance - 1] = true; 
                    }
                }
                else {
                    if(balance+1 <= n/2){
                        dp[i+1][balance+1]=true; // '('
                    }
                    if(balance>0){
                        dp[i+1][balance-1]=true; // ')'
                    }
                }
            }
        }
        return dp[n][0];
    }
}
