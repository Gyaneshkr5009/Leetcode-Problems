class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();
        Map<Integer,Integer> mpp=new HashMap<>();
        int dominantNumber=-1;
        for(int i=0;i<n;i++){
            int num=nums.get(i);
            mpp.put(num , mpp.getOrDefault(num ,0)+1);
            if(mpp.get(num)>n/2) dominantNumber=;
        }
        
        if(dominantNumber==-1) return -1;
        int freq=mpp.get(dominantNumber);
        int ans=n;
        int cnt=0;
        for(int i=0;i<n-1;i++){
            if(nums.get(i)==dominantNumber) cnt++;
            if(cnt > (i+1)/2 && (freq-cnt) > (n-i-1)/2){
                ans=Math.min(ans , i);
            }
        }
        return ans==n?-1:ans;
    }
}
