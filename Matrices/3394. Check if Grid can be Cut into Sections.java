/*
    Sort rectangles by start coordinates for both X and Y axes to handle overlaps.

    Sweep Line Technique: Iterate through sorted intervals to count non-overlapping segments.
    
    Greedy Check: If non-overlapping cuts reach 2 in either X or Y, return true.
    
    Update Max End: Extend the last end point dynamically to merge overlaps.
    
    Time Complexity: O(m log m) + O(m) = O(m log m) due to sorting and linear scan.
*/
//******************************************************************************************************************************
class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int m=rectangles.length;
        if(rectangles==null || n==0) return false;
        int[][] cutOnX=new int[m][2];
        int[][] cutOnY=new int[m][2];
        
        for(int i=0;i<m;i++){
            cutOnX[i][0]=rectangles[i][0]; // startX
            cutOnY[i][0]=rectangles[i][1]; //startY
            cutOnX[i][1]=rectangles[i][2]; //endX
            cutOnY[i][1]=rectangles[i][3]; //endY
        }
        //sort them to bypass overlap series or wrong ans;
        Arrays.sort(cutOnX , (a,b)->Integer.compare(a[0] , b[0]));
        Arrays.sort(cutOnY , (a,b)->Integer.compare(a[0] , b[0]));

        //now we have divided the question into overlapping problems 
        //the only things we need to do is to fing total number of non overlapping series
        //similar to leetcode problem count days without meetings;
        //we will do of both x and y and if our count reach==2 return true;

        int lastEnd=cutOnX[0][1] , TotalCutOnX=0;
        int lastEndForY=cutOnY[0][1] , TotalCutOnY=0;
        for(int i=1;i<m;i++){
            //for X
            if(cutOnX[i][0]-lastEnd>=0) {
                TotalCutOnX++;
                if(TotalCutOnX==2) return true;
            }
            if(cutOnY[i][0]-lastEndForY>=0){
                TotalCutOnY++;
                if(TotalCutOnY==2) return true;
            }
            lastEnd=Math.max(lastEnd, cutOnX[i][1]);
            lastEndForY=Math.max(lastEndForY , cutOnY[i][1]);
        }
        return false;
    }
}

//**********************************************(Optimized Approach => (Reducing external space and utilizing same variable)**********
class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int m=rectangles.length;
        return checkCuts(rectangles , m , 0) || checkCuts(rectangles , m , 1);
    }
    private boolean checkCuts(int[][] grid , int m , int sortIndex){
        Arrays.sort(grid , (a,b) -> Integer.compare(a[sortIndex] , b[sortIndex]));
        int cutCount=0 , lastEnd=grid[0][sortIndex+2];
        for(int i=1;i<m;i++){
            if(grid[i][sortIndex] >= lastEnd){
                cutCount++;
                if(cutCount==2) return true;
            }
            lastEnd=Math.max(lastEnd , grid[i][sortIndex+2]);
        }
        return false;
    }
}

//time complexity:O(mlogm) for sorting + O(m) for iteration;
//space complexity:O(2) external stack space for recursion;
