//time complexity:O(n*m);
//space complexity:O(original.length);
//*********************************************************************(Brute Force)*****************************************************************
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original==null || original.length==0) return new int[][]{};
        int idx=0;
        int[][] arr=new int[m][n];
        for(int i=0 ;i<m ;i++){
            for(int j=0;j<n;j++){
                if(idx<original.length){
                    arr[i][j] = original[idx++];
                }
                else return new int[][]{};
            }
        }
        if(idx<original.length) return new int[][]{};
        return arr;
    }
}

//****************************************************************************************************************************************
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length) return new int[0][0];
        int[][] ans=new int[m][n];
        for(int i=0;i<original.length ;i++){
            ans[i/n][i%n]=original[i];
        }
        return ans;
    }
}
