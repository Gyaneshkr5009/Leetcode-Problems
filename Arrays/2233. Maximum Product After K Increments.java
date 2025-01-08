//time complexity:O(n);
//space complexity:O(n);
//***********************************************************************************************************
class Solution {
    public int maximumProduct(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums) pq.offer(num);

        while(k>0){
            int val=pq.poll();
            pq.offer(val+1);
            k--;
        }
        long res=1 ,mod=1000000007;
        while(!pq.isEmpty()){
            res=(res*pq.poll())%mod;
        }
        return (int)res;
    }
}

//*****************************************************************************************************************************
//time complexity:O(nlogn)
//sapce complexity:O(1);
class Solution {
    public int maximumProduct(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        Arrays.sort(nums);
        while(k>0){
            int ptr=0;
            nums[ptr]++;
            k--;
            while(ptr<nums.length-1 && k>0 && nums[ptr]>nums[ptr+1]){
                ptr++;
                nums[ptr]++;
                k--;
            }
        }
        long res=1;
        for(int i:nums){
            res=(res*i)%1000000007;
        }
        return (int)res;
    }
}
