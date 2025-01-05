//time complexity:O(n);
//space complexity:O(1);
//*********************************************************(normal approach)************************************************
class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] year=new int[2050];
        for(int[] log :logs){
            for(int i=log[0] ;i<log[1] ;i++){
                year[i]++;
            }
        }
        int idx=-1 , ans=-1;
        for(int i=1950;i<2050;i++){
            if(year[i] > ans){
                ans=year[i];
                idx=i;
            }
        }
        return idx;
    }
}
