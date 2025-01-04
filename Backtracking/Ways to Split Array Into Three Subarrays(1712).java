class Solution {
    public int countPalindromicSubsequence(String s) {
        if(s==null || s.length()==0) return 0;
        int n=s.length();
        Set<String> uniquePalindromes = new HashSet<>();
        boolean visited[] =new boolean[n]; // to mark the visited one;
        StringBuilder sb=new StringBuilder();
        helper(s, visited ,sb , uniquePalindromes);
        return uniquePalindromes.size();
    }
    private void helper(String s , boolean[] visited , StringBuilder subStr ,Set<String> uniquePalindromes){
        if(subStr.length()>=3){
            if(isValidPalindrome(subStr)){
                uniquePalindromes.add(subStr.toString());
            }
            return;
        }
        for(int i=0;i<s.length();i++){
            if(!visited[i]){
                visited[i]=true;
                subStr.append(s.charAt(i));
                //recursion for next character of a valid palindrome;
                helper(s , visited , subStr ,uniquePalindromes);
                //backtrack;
                visited[i]=false;
                subStr.deleteCharAt(subStr.length()-1);
            }
        }
    }

    private boolean isValidPalindrome(StringBuilder str){
        return str.charAt(0)==str.charAt(2);
    }
}
