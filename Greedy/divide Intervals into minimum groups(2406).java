    Separate Start and End Points: Store the start and end points of each interval in separate arrays.
    Sort the Arrays: Sort both the start and end points independently.
    Greedy Approach: Traverse the start points and compare them with the end points. If a new start point is greater than the current end point, close the current group by moving the end_ptr; otherwise, a new group is needed.

    Time Complexity: O(n log n)
    Space Complexity: O(n)
//approach sort all strt and end point and group them if strt < end
//******************************************************(greedy Approach)***************************************************************************************
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
