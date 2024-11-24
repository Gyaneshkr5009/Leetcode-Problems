//time complexity:O(n);
//space complexity:O(1);
//********************************************************************************************************************************************************
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int cntNeg=0 , minAbsNeg=Integer.MAX_VALUE;
        long TotalSum=0;

        for(int[] a:matrix){
            for(int num:a){
                if(num<0){
                    cntNeg++;
                }
                TotalSum+=Math.abs(num);
                minAbsNeg=Math.min(minAbsNeg , Math.abs(num));
            }
        }

        
        //if neg count is even means we can change all neg to positive;
        if(cntNeg%2==0) return TotalSum;

        //if we got odd then sub the MaxNeg two times from totalSum and thats the ans;
        return TotalSum-2*minAbsNeg;
    }
}
