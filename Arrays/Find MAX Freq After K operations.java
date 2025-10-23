class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxi=nums[0];
        for(int num:nums){
            maxi=Math.max(maxi , num);
        }

        //finding the freq of the numbers;
        int[] freq=new int[maxi+1];
        for(int num:nums){
            freq[num]++;
        }

        //calculating cumulative sum of their freq
        for(int i=1;i<freq.length;i++){
            freq[i]+=freq[i-1];
        }

        int ans=0;

        for(int target = 0 ; target <= maxi; target++){
            if(freq[target] == 0) continue;
            int minVal = Math.max(target -k , 0);
            int maxVal = Math.min(target+k , maxi);

            int totalCnt = freq[maxVal] - (minVal > 0 ? freq[minVal-1] : 0);
            int targetCnt = freq[target] - (target > 0 ? freq[target-1] : 0);

            int needConversion = totalCnt-targetCnt;
            int maxPossibleFreq= targetCnt + Math.min(needConversion , numOperations);
            ans=Math.max(ans, maxPossibleFreq);
        }
        return ans;
    }
}
