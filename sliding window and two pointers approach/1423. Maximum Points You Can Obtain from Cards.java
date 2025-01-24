class Solution {
    public int maxScore(int[] arr, int k) {
        int leftsum=0;
        int rightsum=0;
        int maxsum=Integer.MIN_VALUE;
        // idher hm suru ke kth element tk ka sum le lenge or use maxsum me store ker denge;
        for(int i=0; i<k ;i++){
            leftsum+=arr[i];
        }
        // now storing the leftsum in maxsum;
        maxsum=Math.max(maxsum , leftsum+rightsum);
        // ab hm kya krenge ki left se kuch element and right jo ki end se suru hoga usse kuch lenege taki k element poora ho ske
        int rightind=arr.length-1;
        for(int i=k-1; i>=0; i--){
            leftsum-=arr[i]; // idher hm left se jitne km element pic krenge to right se utna hi pick ker lenge
            rightsum+=arr[rightind--]; // yahan hm rightsum me rightind ke element lenge or rightind ko ek value niche ker denge;
            maxsum=Math.max(maxsum , leftsum+rightsum);
        }
        return maxsum;
    }
}
