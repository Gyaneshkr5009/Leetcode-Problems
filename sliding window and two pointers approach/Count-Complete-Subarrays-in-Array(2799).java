//time complexity:O(n);
//space complexity:O(k);
//*******************************************************************************************************************************
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int[] numbers=new int[10001];
        int k=0;
        for(int n:nums){
            if(numbers[n]==0){
                numbers[n]=1;
                k++;
            }
        }
        return count(nums , k) - count(nums , k-1);
    }
    int count(int[] nums , int k){
        int cnt=0;
        int l=0 , r=0;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        while(r<nums.length){
            mpp.put(nums[r] , mpp.getOrDefault(nums[r] , 0)+1);
            while(mpp.size()>k){
                mpp.put(nums[l] , mpp.get(nums[l])-1);
                if(mpp.get(nums[l])==0) mpp.remove(nums[l]);
                l++; 
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}
