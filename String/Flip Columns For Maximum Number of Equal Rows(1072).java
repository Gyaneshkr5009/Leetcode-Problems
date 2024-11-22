//time complexity: O(n⋅m)
//space complexity: O(n⋅m)
//***************************************************************************************************************************************
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n=matrix.length , m=matrix[0].length;

        HashMap<String , Integer> patternsCount=new HashMap<>(); // for calculating freq of row having same elements;
        for(int i=0;i<n ;i++){
            StringBuilder original=new StringBuilder();
            StringBuilder flipped=new StringBuilder();

            //we create a original and flipper version and store it into hashmap;
            for(int j=0 ;j<m ;j++){
                original.append(matrix[i][j]);
                flipped.append(1-matrix[i][j]);
            }
            String originl=original.toString();
            String flipp=flipped.toString();

            patternsCount.put(originl , patternsCount.getOrDefault(originl ,0)+1);
            patternsCount.put(flipp , patternsCount.getOrDefault(flipp ,0)+1);
        }

        //in hashMap we have freq of flipped as well as original sting so those who appears more will be our ans;
        int cnt=0;
        for(int value : patternsCount.values()){
            cnt=Math.max(cnt , value);
        }
        return cnt;
    }
}
