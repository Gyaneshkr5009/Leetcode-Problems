//time complexity:O(n);
//space complexity:O(k);
//***********************************************************************************************************************************************************************
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums, k-1);
    }
    public static int atMost(int[] arr, int k){
        int l=0;
        int r=0;
        int cnt=0;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        while(r<arr.length){
            mpp.put(arr[r] ,mpp.getOrDefault(arr[r] , 0)+1);
            while(mpp.size()>k){
                mpp.put(arr[l] , mpp.get(arr[l])-1);
                if(mpp.get(arr[l])==0){
                    mpp.remove(arr[l]);

                }
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}
