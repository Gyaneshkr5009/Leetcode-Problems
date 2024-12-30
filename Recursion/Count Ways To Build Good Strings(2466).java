class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1000000007;
        int[] dp = new int[high + 1];
        dp[0] = 1; // Base case: There's one way to create an empty string.

        for (int length = 1; length <= high; length++) {
            if (length >= zero) {
                dp[length] = (dp[length] + dp[length - zero]) % mod;
            }
            if (length >= one) {
                dp[length] = (dp[length] + dp[length - one]) % mod;
            }
        }

        int result = 0;
        for (int length = low; length <= high; length++) {
            result = (result + dp[length]) % mod;
        }

        return result;
    }
}
//*************************************************************************(not optimized approach [Brute-Force Approach])**********************************************************
class Solution {
    public int result=0 , mod = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        if(low>high) return 0;
        helper(low , high , zero , one , 0);
        System.out.println(result);
        return result;
    }
    private void helper(int low, int high , int zero , int one , int currentLength){
        if(currentLength>high) return;
        if(currentLength >=low){
            result=(result+1)%mod;
        }
        // appending '1'
        helper(low, high , zero , one , currentLength+one);
        //appending'0';
        helper(low,high,zero , one , currentLength+zero);
    }
}
