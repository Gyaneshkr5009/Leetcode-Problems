//time complexity:O(n)
//space complexity:O(n)

//***************************************************************************(optimal approach dfs traversal)*******************************************

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image.length==0) return new int[0][0];

        int preColor=image[sr][sc];
        if(preColor==color) return image;

        dfs(image , sr, sc , color , preColor);
        return image;
    }

    private void dfs(int[][] image , int row , int col , int color , int preColor){
        //if row and col exceeds then stop;
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) return;
        //image color !=precolor dont push stop;
        if(image[row][col]!=preColor) return ;
        image[row][col]=color;

        //all neighbours of that index there are four(top,right,bottom ,left);
        int[] dRow={-1 ,0 , 1 ,0};
        int[] dCol={0 , 1 , 0 , -1};

        for(int i=0 ;i<4 ;i++){
            int nRow=row+dRow[i];
            int nCol=col+dCol[i];
            dfs(image , nRow , nCol , color , preColor);
        }
    }
}


//***********************************************************************************************************************************************************************
//time complexity:O(n);
//space complexity:O(n)
//******************************************************************(bfs traversal)***************************************************************************
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n  =image.length;
        int m=image[0].length;

        if(image==null || image.length==0) return new int[0][0]; //some exceptions;
        int preColor=image[sr][sc];
        //if preColor =color then dont  need to change anything it will bring no effect so return image;
        if(preColor==color) return image;
        image[sr][sc]=color;


        //bfs traversal;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(sr ,sc));

        int[] dRow={-1 , 0 , 1 ,0};
        int[] dCol={0 , 1, 0 , -1};
        while(!q.isEmpty()){
            Pair pair=q.poll();
            int row=pair.row;
            int col=pair.col;
            
            for(int i=0 ;i<4 ;i++){
                int nRow=row + dRow[i];
                int nCol=col + dCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && image[nRow][nCol]==preColor){
                    image[nRow][nCol]=color;
                    q.offer(new Pair(nRow , nCol));
                }
            }
        }
        return image;
    }
}
class Pair{
    int row , col;
    Pair(int row , int col){
        this.row=row;
        this.col=col;
    }
}
