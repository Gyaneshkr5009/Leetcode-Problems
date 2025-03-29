class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0) return new int[][]{newInterval};
        ArrayList<int[]> ans=new ArrayList<>();
        for(int[] inter:intervals) ans.add(inter);
        ans.add(newInterval);
        Collections.sort(ans , (a,b) -> Integer.compare(a[0],b[0])); //sort on the basis of their start point;

        ArrayList<int[]> finalResult=new ArrayList<>();

        int strtPt=ans.get(0)[0] , endPt=ans.get(0)[1];
        for(int i=1;i<ans.size();i++){
            if(ans.get(i)[0]>endPt){
                finalResult.add(new int[]{strtPt , endPt});
                strtPt=ans.get(i)[0];  //updating my startPt;
            }
            //if the strt of ith array is not greter then prev then remove that entry;
            endPt=Math.max(endPt , ans.get(i)[1]);
        }
        finalResult.add(new int[]{strtPt ,endPt});
        return finalResult.stream().toArray(int[][]::new);
    }
}
