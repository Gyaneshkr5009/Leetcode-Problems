/*
    Backtracking: Generate all possible combinations of parentheses by placing '(' and ')' recursively.
    Check Validity: Use a helper function to validate if the generated string has balanced parentheses.
    Recursive Generation: Recursively add '(' and ')' to form all combinations, then backtrack to explore other possibilities.
    Base Case: When a string of length 2*n is formed, validate it and add to the result if valid.

    Time Complexity: O(2^n)
    Space Complexity: O(n)
*/
//***********************************************************************(normal approach)**************************************************************
class Solution {
    List<String> ans=new ArrayList<>(); // list to store all valid parantheses;
    public List<String> generateParenthesis(int n) {
        if(n==0) return new ArrayList<>();

        String curr="";
        solve(n , curr);
        return ans;
    }

    private void solve (int n ,String curr){
        if(curr.length()==2*n){
            //if parantheses formed is valid just add it to ans list;
            if(isValid(curr)){
                ans.add(curr);
            }
            return;
        }
        //checking for '(' in recursion 
        curr+='(';
        solve(n , curr);
        curr=curr.substring(0 , curr.length()-1);//backtrack
        //now checking for ')' in recursion
        curr+=')';
        solve(n , curr);
    }
    private boolean isValid(String s){
        int openBr=0 , closeBr=0;
        for(char c:s.toCharArray()){
            if(c=='(') openBr++;
            else if(c==')' && openBr>0){
                openBr--;
            }
            else closeBr++;
        }
        return openBr+closeBr==0;
    }
}

//*****************************************************************************(optimized )****************************************************************
class Solution {
    List<String> ans=new ArrayList<>(); // list to store all valid parantheses;
    public List<String> generateParenthesis(int n) {
        if(n==0) return new ArrayList<>();

        String curr="";
        solve(n , curr , 0 , 0);
        return ans;
    }

    private void solve (int n ,String curr , int openBr , int closeBr){
        if(curr.length()==2*n){
            ans.add(curr);
            return;
        }
        //checking for '(' in recursion 
        if (openBr < n) {
            curr += '(';
            solve(n, curr, openBr + 1, closeBr);
            curr = curr.substring(0, curr.length() - 1);
        }
        if (closeBr < openBr) {
            curr += ')';
            solve(n, curr, openBr, closeBr + 1);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
    
}
