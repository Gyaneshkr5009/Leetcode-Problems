//timeComplexity:O(n*m);
//space complexity:O(n*m);
//*********************************************************************************************************************************************
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions={ {0,1} , {1,0} ,{0,-1} , {-1,0}};
        int[][] result=new int[rows*cols][2];
        int dir=0;
        int steps=0;
        result[0] = new int[]{rStart , cStart};
        int idx=1;
        while(idx < rows*cols){
            if(dir==0 || dir==2) steps++;
            for(int i=0 ; i<steps ;i++){
                rStart += directions[dir][0];
                cStart += directions[dir][1];

                if((rStart >=0 && rStart < rows) && (cStart >=0 && cStart<cols)){
                    result[idx++] = new int[]{rStart , cStart};
                }
            }
            dir = (dir+1)%4;
        }
        return result;
    }
}
