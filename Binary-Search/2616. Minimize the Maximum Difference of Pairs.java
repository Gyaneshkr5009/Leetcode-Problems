class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n=nums.length;
        Arrays.sort(nums);
        int left=0 , right=nums[n-1]-nums[0];
        int ans=0;

        while(left<=right){
            int mid=left+(right-left)/2;

            if(isPairPossible(nums, p , mid)){
                ans=mid;
                right=mid-1;
            }
            else left=mid+1;
        }
        return ans;
    }
    private boolean isPairPossible(int[] nums, int p , int target){
        int cnt=0;
        for(int i=0;i<nums.length-1;i++){
            int value=nums[i+1]-nums[i];
            if(value <= target){
                cnt++;
                i++;
                if(cnt>=p) return true;
            }
        }
        return cnt>=p;
    }
}
