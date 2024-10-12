/*
    #Sort the Intervals: Sort the intervals based on the start time.
    #Iterate Through Intervals: Keep track of the current interval, and for each subsequent interval:
       > If it overlaps with the current interval, merge them by updating the current interval’s end.
       > Otherwise, add the current interval to the result list and move on to the next interval.
    #Return Merged Intervals: Convert the list of merged intervals to a 2D array.

    #Time Complexity: O(n log n) due to sorting.
    #Space Complexity: O(n) for storing the merged intervals.
*/
//***********************************************************************(greedy approach)**********************************************************************
class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n==0) return new int[0][0];

        //sorting arrays based on strt time;
        Arrays.sort(intervals , (a,b)-> a[0]-b[0]);

        List<int[]>merge =new ArrayList<>();
        
        int[] currentInterval=intervals[0];  //strting with the first interval
        merge.add(currentInterval);

        for(int i=1;i<n ;i++){
            int currentStrt=currentInterval[0];
            int currentEnd=currentInterval[1];
            int nextStrt=intervals[i][0];
            int nextEnd=intervals[i][1];

            if(currentEnd>=nextStrt){
                //means overlapping time intervals , so simple update currentEnd
                currentInterval[1]=Math.max(currentEnd , nextEnd);
            }
            else{
                currentInterval=intervals[i];
                merge.add(currentInterval);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
