class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;

        int[] dp=new int[n];
        int length=0;
        Arrays.sort(words ,(a,b) ->  a.length() - b.length());

        for(int i=0 ; i<n; i++){
            for(int j=0 ; j < i ; j++){
                if(checkPossible(words[i] , words[j]) && 1+ dp[j] > dp[i]){
                    dp[i]=1+dp[j];
                }
            }
            length=Math.max(length , dp[i]);
        }
        return length+1;
    }

    //we are checking is that out s2 is a part of s1 or not 
    //eg  bcda and bda so we check until both end if both pointers reaches end means true else false;
    private boolean checkPossible(String s1 , String s2){
        if(s1.length() != 1+ s2.length()) return false;
        int first=0 , second=0;
        while(first<s1.length()){
            if(second<s2.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }
            else first++;
        }
        if(first==s1.length() && second==s2.length()) return true;
        return false;
    }
}
