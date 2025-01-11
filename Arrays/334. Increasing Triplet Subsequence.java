class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums==null || nums.length==0) return false;
        int first=Integer.MAX_VALUE;
        int sec=Integer.MAX_VALUE;
        for(int num:nums){
            //if no is smaller then first;
            if(num<=first){
                first=num;
            }
            //if no is bigger then first but smaller then sec;
            else if(num<=sec) sec=num;
            //if no is bigger then both means we got the ans;
            else{
                return true;
            }
        }
        return false;
    }
}
