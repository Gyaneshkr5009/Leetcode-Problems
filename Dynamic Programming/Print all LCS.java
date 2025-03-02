class Solution {
    public List<String> all_longest_common_subsequences(String s, String t) {
        int n=s.length() , m=t.length();
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();
        int[][] dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else dp[i][j]=Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        
        Set<String> set=new HashSet<>();
        backtrack(arr1 , arr2 , dp , new StringBuilder() ,set , n , m);
        
        List<String> result=new ArrayList<>(set);
        Collections.sort(result);
        return result;
        
    }
    private void backtrack(char[] arr1 , char[] arr2 , int[][] dp , StringBuilder sb , Set<String> result, int idx1 , int idx2){
        if(idx1==0 || idx2==0){
            result.add(sb.reverse().toString());
            sb.reverse();
            return;
        }
        if(arr1[idx1-1] == arr2[idx2-1]){
            sb.append(arr1[idx1-1]);
            backtrack(arr1 , arr2 , dp , sb , result, idx1-1 , idx2-1);
            sb.deleteCharAt(sb.length()-1); //backtrack;
        }
        else{
            if (dp[idx1 - 1][idx2] == dp[idx1][idx2]) {
                backtrack(arr1 , arr2 , dp , sb ,result ,idx1-1 , idx2);
            }
            if (dp[idx1][idx2 - 1] == dp[idx1][idx2]) {
                backtrack(arr1 , arr2 , dp , sb ,result ,idx1 , idx2-1);
            }
        }
    }
}
