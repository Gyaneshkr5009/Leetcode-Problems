class Solution {
    public int minCostToMoveChips(int[] position) {
        if(position==null || position.length==0) return 0;
        int even=0 , odd=0;
        for(int chips:position){
            if(chips%2==0){
                even++;
            }
            else odd++;
        }
        return Math.min(odd , even);
    }
}
