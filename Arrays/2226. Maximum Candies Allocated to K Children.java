class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum=0 ;
        int max=0;
        for(int a:candies){
            sum+=a;
            max = Math.max(max, a);
        }
        if(sum<k) return 0;
        
        int left=1 , right=max ;
        // using binary search to get the ans;
        while(left<=right){
            int mid=left+(right-left)/2;
            long cnt=0;
            for(int i=0;i<candies.length;i++){
                cnt+=candies[i]/mid;
                if(cnt>=k) break;
            }
            if(cnt>=k){
                left=mid+1;
            }
            else right=mid-1;
        }
        return right;
    }
}
