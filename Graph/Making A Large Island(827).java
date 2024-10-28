class Solution {
    private boolean isValid(int row , int col, int n){
        return (row<n && col <n && row>=0 && col>=0);
    }
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length==0) return 0;
        int n=grid.length;

        // We are first separating each grid node into a separate entity, where each node is initially its own parent.
        DisjointSet ds=new DisjointSet(n*n);
        //step 1 : we are looking to connect all one's into  a components;
        for(int row=0 ; row<n ; row++){
            for(int col=0 ; col<n ;col++){
                if(grid[row][col]==0) continue;
                int[] dRow={-1 , 0 ,1 , 0};
                int[] dCol={0 , 1 , 0 , -1};
                for(int i=0;i<4 ;i++){
                    int nRow=row+dRow[i];
                    int nCol=col+dCol[i];
                    //if we check if the adjacent 1 is from inside the grid;
                    if(isValid(nRow , nCol , n) && grid[nRow][nCol]==1){
                        //converting grid element into numbering format from 1 to n*n;
                        int nodeNo=row*n + col;
                        int adjNodeNo=nRow * n + nCol;
                        ds.unionBySize(nodeNo , adjNodeNo); // this will joint 2 node into single ulp;
                    }
                } 
            }
        }
        //step 2 : now check for the zeroes 
        int max=0; // this will store the max size of an island we can create;
        for(int row=0 ; row<n ; row++){
            for(int col=0 ; col<n ;col++){
                if(grid[row][col]==1) continue;
                Set<Integer> hs=new HashSet<>();
                int[] dRow={-1 , 0 ,1 , 0};
                int[] dCol={0 , 1 , 0 , -1};
                for(int i=0;i<4 ;i++){
                    int nRow=row+dRow[i];
                    int nCol=col+dCol[i];
                    //we are adding all neighbour island size using set to remove cases like landlock island or multiple sides cover with the same island;
                    if(isValid(nRow , nCol , n)){
                        if(grid[nRow][nCol]==1){
                            hs.add(ds.findUPar(nRow*n + nCol));
                        }
                    }
                } 
                int islandSize=0;
                for(Integer num: hs){
                    islandSize+=ds.size.get(num); //+1 because 0 we have converted to 1 ;
                }
                max=Math.max(islandSize + 1, max);
            }
        }
        for(int cellNo=0 ; cellNo<n*n ;cellNo++){
            max=Math.max(max , ds.size.get(ds.findUPar(cellNo)));
        }
        return max;
    }
}
class DisjointSet{
    ArrayList<Integer> parent =new ArrayList<>(), rank=new ArrayList<>() , size=new ArrayList<>();
    
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUPar(int node){
        if(node==parent.get(node)) return node;
        int ulp=findUPar(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);
    }
    
    public void unionByRank(int u ,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        //if both ultimate parent are same return nothing;
        if(ulp_u==ulp_v) return ;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
        }
        else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } 
        else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }
    
    public void unionBySize(int u, int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v) return ;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
