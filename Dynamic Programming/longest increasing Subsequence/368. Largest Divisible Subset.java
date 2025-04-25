class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        if (n == 0) return new ArrayList<>();
        
        Arrays.sort(nums);
        int[] dp=new int[n];
        Arrays.fill(dp , 1);

        int[] hash=new int[n];

        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if((nums[j]%nums[i]==0 || nums[i]%nums[j]==0) && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;
        
        for (int i = 0; i < n; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>(Collections.nCopies(ans, 0));
        int idx=ans-1;
        while (hash[lastIndex] != lastIndex) {
            result.set(idx-- ,nums[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        result.set(idx , nums[lastIndex]);
        
        
        return result;  
    }
    
}
