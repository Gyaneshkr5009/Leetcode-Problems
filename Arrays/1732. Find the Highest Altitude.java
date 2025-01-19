class Solution {
    public int largestAltitude(int[] gain) {
        int n =gain.length;
        int total=0, min=0;
        for(int i:gain){
            total+=i;
            min=Math.max(min , total);
        }
        return min;
    }
}
