class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        
        int[] dp=new int[n];
        int[] cnt=new int[n];
        int length=1;
        for(int i=0;i<n;i++){
            dp[i]=1;
            cnt[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j] <nums[i]){
                    if(dp[j]+1 > dp[i]) {
                        dp[i]=1+dp[j];
                        cnt[i]=cnt[j];
                    }
                    else if(dp[j]+1 == dp[i]) {
                        cnt[i]+=cnt[j];
                    }
                }
            }
            length=Math.max(length , dp[i]);
        }
        int ans=0;
        for(int i=0 ;i<n ;i++){
            if(dp[i] == length){
                ans+=cnt[i];
            }
        }
        return ans;
    }
}
