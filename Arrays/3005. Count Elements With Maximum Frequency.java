class Solution {
    public int maxFrequencyElements(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int cnt=0 , maxFreq=0;

        //optimizing more
        int max=Integer.MIN_VALUE;
        for(int a:nums){
            max=Math.max(max, a);
        }


        int[] number=new int[max+1];

        for(int a : nums){
            number[a]++;
            if(number[a] > maxFreq){
                maxFreq = number[a];
                cnt=1;
            }
            else if(maxFreq == number[a]){
                cnt++;
            }
        }
        return cnt*maxFreq;
    }
}
