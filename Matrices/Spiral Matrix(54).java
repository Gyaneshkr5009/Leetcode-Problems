//time complexity:O(n*m);
//space complexity:O(n*m);
//**************************************************************************************************************************
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>list =new ArrayList<>();
        // if(matrix==null ||matrix.length==0||matrix[0].length==0){
        //     return null;
        // }
        int row=0;
        int lastrow=matrix.length-1;
        int col=0;
        int lastcol=matrix[0].length-1;
        int dir=0;
        while(row<=lastrow && col<=lastcol){
            if(dir==0){
                for(int i=col;i<=lastcol;i++){
                    list.add(matrix[row][i]);
                }
                row+=1;
            }
            else if(dir==1){
                for(int i=row;i<=lastrow;i++){
                    list.add(matrix[i][lastcol]);
                }
                lastcol-=1;
            }
            else if(dir==2){
                for(int i=lastcol;i>=col;i--){
                    list.add(matrix[lastrow][i]);
                }
                lastrow-=1;
            }
            else if(dir==3){
                for(int i=lastrow;i>=row;i--){
                    list.add(matrix[i][col]);
                }
                col+=1;
            }
            dir=(dir+1)%4;
        }
        return list;
    }
}
