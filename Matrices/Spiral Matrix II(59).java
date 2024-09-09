//time complexity1:O(n*m);
//space complexity:O(n*m);
//**************************************************************************************************************************
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr=new int[n][n];
        int row=0;
        int lastrow=n-1;
        int col=0;
        int lastcol=n-1;
        int dir=0;
        int num=1;
        if(arr==null || arr.length==0 ||arr[0].length==0){
            return null;
        }
        while(row<=lastrow && col<=lastcol){
            if(dir==0){
                for(int i=col;i<=lastcol;i++){
                    arr[row][i]=num;
                    num+=1;
                }
                row+=1;
            }
            else if(dir==1){
                for(int i=row;i<=lastrow;i++){
                    arr[i][lastcol]=num;
                    num+=1;
                }
                lastcol-=1;
            }
            else if(dir==2){
                for(int i=lastcol;i>=col;i--){
                    arr[lastrow][i]=num;
                    num+=1;
                }
                lastrow-=1;
            }
            else if(dir==3){
                for(int i=lastrow;i>=row;i--){
                    arr[i][col]=num;
                    num+=1;
                }
                col+=1;
            }
            dir=(dir+1)%4;
        }
        return arr;
    }
}
