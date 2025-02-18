class Solution {
    public String smallestNumber(String pattern) {
        int[] nums=new int[pattern.length()+1];
        int val=1;
        for(int i=0 ;i<nums.length;i++){
            nums[i]=val;
            val++;
        }
        while(true){
            int swap=0;
            for(int i=0;i<pattern.length();i++){
                if(pattern.charAt(i)=='I' && nums[i]>=nums[i+1]){
                    int temp=nums[i];
                    nums[i]=nums[i+1];
                    nums[i+1]=temp;
                    swap++;
                }
                if(pattern.charAt(i)=='D' && nums[i]<=nums[i+1]){
                    int temp=nums[i];
                    nums[i]=nums[i+1];
                    nums[i+1]=temp;
                    swap++;
                }
            }
            if(swap==0) break;
        }
        StringBuilder sb=new StringBuilder();
        for(int a:nums) sb.append(a);
        return sb.toString();
    }
}
