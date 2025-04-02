class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length ;
        int[] maxi=new int[n];
        maxi[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(maxi[i+1]>nums[i]){
                maxi[i]=maxi[i+1];
            }
            else{
                maxi[i]=nums[i];
            }
        }
        //now i got the maxi array that contains max element upto that index;
        long maxTriplet=Long.MIN_VALUE;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                long triplet=(nums[i]-nums[j])*(long)maxi[j+1];
                maxTriplet=Math.max(maxTriplet , triplet);
            }
        }
        return maxTriplet<0?0:maxTriplet;
    }
}
