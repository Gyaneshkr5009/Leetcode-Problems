
//*******************************************************************************************************************
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        HashMap<Integer , int[]> mpp=new HashMap<>();
        for(int i=0 ; i<n;i++){
            for(int j=0;j<m;j++){
                mpp.put(mat[i][j] , new int[]{i ,j});
            }
        }
        
        int[] rowPaintCount = new int[n];
        int[] colPaintCount = new int[m];

        for(int i=0;i<arr.length ;i++){
            int row=mpp.get(arr[i])[0];
            int col=mpp.get(arr[i])[1];
            rowPaintCount[row]++;
            colPaintCount[col]++;
            if(rowPaintCount[row]==m || colPaintCount[col]==n) return i;
        }
        return -1;
    }
}


//*********************************************************(brute Force)*******************************************
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        boolean[][] visited=new boolean[n][m];
        HashMap<Integer , int[]> mpp=new HashMap<>();
        for(int i=0 ; i<n;i++){
            for(int j=0;j<m;j++){
                mpp.put(mat[i][j] , new int[]{i ,j});
            }
        }
        for(int i=0 ;i <arr.length ;i++){
            int row=mpp.get(arr[i])[0];
            int col=mpp.get(arr[i])[1];
            visited[row][col]=true;
            if (checkPainted(row , col , visited)) return i;
        }
        return -1;
    }
    private boolean checkPainted(int currRow , int currCol , boolean[][] visited){
        int n=visited.length;
        int m=visited[0].length;
        boolean rowComplete=true;
        for(int i=0;i<n ;i++){
            if(!visited[i][currCol]){
                rowComplete=false;
                break;
            }
        }
        boolean colComplete=true;
        for(int i=0;i<m;i++){
            if(!visited[currRow][i]){
                colComplete =false;
                break;
            } 
        }
        return rowComplete || colComplete;
    }
}
