//time complexity:O(n*k);
//space complexity:O(1)
//*******************************************************************************************************************
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if(nums==null || nums.length==0) return new int[]{};
        for(int i=0;i<k ;i++){
            int min=nums[0] , idx=0;
            for(int j=0;j<nums.length ;j++){
                if(min>nums[j]){
                    min=nums[j];
                    idx=j;
                }
            }
            nums[idx]=min*multiplier;
        }
        return nums;
    }
}

//*********************************************************(brute force)*****************************************************
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if(nums==null || nums.length==0) return new int[]{};
        int n=nums.length;
        int[] ans=new int[n];
        PriorityQueue<Pair> min=new PriorityQueue<>(
            (a,b) ->{
                if(a.val!=b.val) return Integer.compare(a.val , b.val);
                else return Integer.compare(a.idx , b.idx);
            }
        );
        for(int i=0 ;i< n ;i++){
            min.offer(new Pair(nums[i] , i));
        }
        while(k>0 && !min.isEmpty()){
            Pair temp=min.poll();
            temp.val*=multiplier;
            min.offer(temp);
            k--;
        }

        while(!min.isEmpty()){
            Pair temp=min.poll();
            ans[temp.idx]=temp.val;
        }
        return ans;
    }
}
class Pair{
    int val;
    int idx;
    Pair(int val , int idx){
        this.val=val;
        this.idx=idx;
    }
}
