class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long Zeroes1=0 , sum1=0 , Zeroes2=0 , sum2=0;
        for(int a=0 ; a<nums1.length ; a++){
            if(nums1[a] == 0){
                Zeroes1++;
                nums1[a]=1;
            }
            sum1 += nums1[a];
        }

        for(int b=0 ; b< nums2.length ; b++){
            if(nums2[b] == 0){
                Zeroes2++;
                nums2[b]=1;
            }
            sum2+= nums2[b];
        }

        if((sum1 < sum2 && Zeroes1 == 0) || (sum2 < sum1 && Zeroes2 == 0)){
            return -1;
        }
        return Math.max(sum1 , sum2);
    }
}
