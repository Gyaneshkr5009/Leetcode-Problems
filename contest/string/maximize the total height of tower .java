class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        if(maximumHeight==null || maximumHeight.length==0) return 0;
        Arrays.sort(maximumHeight);

        int n = maximumHeight.length;
        long totalHeight = 0;
        int nextAvailableHeight = Integer.MAX_VALUE;
        for(int i=n-1;i>=0 ;i--){
            int heightToAssign = Math.min(maximumHeight[i], nextAvailableHeight);

            if (heightToAssign <= 0) {
                return -1;
            }
            totalHeight += heightToAssign;
            nextAvailableHeight = heightToAssign - 1;
        }
        return totalHeight;
    }
}
