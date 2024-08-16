  Time complexity:O(n)
  Space complexity:O(1)

********************************************************************************************************************************************************
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min=arrays.get(0).get(0);
        int max=arrays.get(0).get(arrays.get(0).size()-1);
        int distance=0;
        for(int i=1;i<arrays.size() ;i++){
            //subtracting first array min with all array max to get the highest;
            distance=Math.max(distance , Math.abs(min - arrays.get(i).get(arrays.get(i).size()-1)));
            //subtracting first array max with all array min to get the highest;
            distance=Math.max(distance , Math.abs(max - arrays.get(i).get(0)));
            //updating min and max as well;
            min=Math.min(min , arrays.get(i).get(0));
            max=Math.max(max , arrays.get(i).get(arrays.get(i).size()-1));
        }
        return distance;
    }
}
