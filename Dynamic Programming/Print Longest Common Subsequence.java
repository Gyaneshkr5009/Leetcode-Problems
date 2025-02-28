class Solution {
    public List<String> all_longest_common_subsequences(String s, String t) {
        int m=s.length() , n=t.length();
        
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m ;i++){
            for(int j=0 ; j <=n ;j++){
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j]=1+ dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        int length=dp[m][n];
        int len=dp[n][m];
        int i=n;
        int j=m;
        
        int index = len-1;
        String str="";
        for(int k=1; k<=len;k++){
            str +="$"; // dummy string
        }
        StringBuilder ss= new StringBuilder(s1);
        StringBuilder str2=new StringBuilder(str);
        while(i>0 && j>0){
            if(ss.charAt(i-1) == s2.charAt(j-1)){
                str2.setCharAt(index,ss.charAt(i-1) ); 
                index--;
                i--;
                j--;
            }
            else if(ss.charAt(i-1)>s2.charAt(j-1)){
                i--;
            }
            else j--;
        }
        System.out.println(str2);
    }
}
