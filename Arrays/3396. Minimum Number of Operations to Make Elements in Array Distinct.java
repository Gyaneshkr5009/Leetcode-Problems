class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        //base case: if we have a length < 3 then
        if(n<3){
            if(n==1) return 0; //cause its already unique
            if(nums[0]!=nums[1]) return 0;
            else return 1;
        }

        int[] number=new int[101];
        for(int i:nums) number[i]++;
        int ansIdx=-1 , idx=0;

        while(idx<n){
            //if a number count is greater then 1 means it repeat somewhere means it will not create a distinct array
            if(number[nums[idx]]>1 ||(idx+1<n && number[nums[idx+1]]>1) || (idx+2<n && number[nums[idx+2]]>1)){
                if(idx<n) number[nums[idx]]--;
                if(idx+1<n) number[nums[idx+1]]--;
                if(idx+2<n) number[nums[idx+2]]--;
                ansIdx=idx;
                idx+=3;
            }
            //if all are unique means we need to break here;
            else idx+=3;
        }
        return ansIdx==-1?0:ansIdx/3+1;
    }
}
