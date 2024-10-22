/*
    =>Initialize the Matrix: Replace -1 with a large value (treated as infinity) and set diagonal elements (distance to self) to 0.
    =>Dynamic Programming Update: For each intermediate vertex via, update the shortest paths between all pairs (i, j) using the relation mat[i][j] = min(mat[i][j], mat[i][via] + mat[via][j]).
    =>Post-process Matrix: Convert large values (unreachable vertices) back to -1.

    Time Complexity: O(N³)
    Space Complexity: O(1) (In-place transformation)
*/
//******************************************************************************************************************************************
class Solution {
    public void shortestDistance(int[][] mat) {
        if(mat==null || mat.length==0) return ;
        int n=mat.length;
        
        
        // -1 means there is no edge; so for finding out the min path we make -1 as MAX_VALUE;
        //and if i==j , means a node approaching itself that always cost 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==-1){
                    mat[i][j]=(int)1e9;
                }
                if(i==j) mat[i][j]=0;
            }
        }
        
        //now we fill the matrix via nodes;
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]=Math.min(mat[i][j] , mat[i][via]+mat[via][j]);
                }
            }
        }
        
        //now we revert back those that are unapproachable;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==(int)1e9){
                    mat[i][j]=-1;
                }
            }
        }
        
        
    }
}
