//time complexity:O(nlogn)
//space complexity:O(n)
//**********************************************************************************************************************************
class Solution {
    public int minGroups(int[][] intervals) {
        int n=intervals.length;
        int[] strtPoint=new int[n];
        int[] endPoints=new int[n];

        //seperating start and end points;
        for(int i=0;i<n;i++){
            strtPoint[i]=intervals[i][0];
            endPoints[i]=intervals[i][1];
        }

        //sort start and end points
        Arrays.sort(strtPoint);
        Arrays.sort(endPoints);

        int end_ptr=0 , groupCnt=0;
        for(int strt: strtPoint){
            if(strt>endPoints[end_ptr]){
                end_ptr++;
            }
            else groupCnt++;
        }
        return groupCnt;
    }
}
