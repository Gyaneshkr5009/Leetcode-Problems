//time complexity:O(n*m) : space complexity
//*********************************************************************************************************************************
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        //step 1 transpose of the matrix;
        int n=box.length, m=box[0].length;
        char[][] transpose=new char[m][n];

        for(int i=0;i<n;i++){
            for(int j=0 ; j< m ;j++){
                transpose[j][i]=box[i][j];
            }
        }

        //step 2 : rotate it to 90 deg;

        for(char[] row:transpose){
            int stp=0 , edp=n-1;
            while(stp<edp){
                char temp=row[stp];
                row[stp]=row[edp];
                row[edp]=temp;
                stp++;
                edp--;
            }
        }

        //now,we have to apply gravity , for that strt from the bottom;
        for(int j=0 ;j< n ;j++){
            for(int i=m-1 ; i >=0 ;i--){
                //if '.' found in bottom use k pointer to find the '#' and swap it;
                if(transpose[i][j]=='.'){
                    int stoneRow=-1;
                    for(int k=i-1 ; k>=0 ;k--){
                        if(transpose[k][j]=='*') break;
                        else if(transpose[k][j]=='#'){
                            stoneRow=k;
                            break;
                        }
                    }
                    if(stoneRow!=-1){
                        transpose[stoneRow][j]='.';
                        transpose[i][j]='#';
                    }
                }
            }
        }
        return transpose;
    }
}
//********************************************************************(same TC and SC)***************************************
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        //step 1 transpose of the matrix;
        int n=box.length, m=box[0].length;
        char[][] transpose=new char[m][n];

        for(int i=0;i<n;i++){
            for(int j=0 ; j< m ;j++){
                transpose[j][i]=box[i][j];
            }
        }

        //step 2 : rotate it to 90 deg;

        for(char[] row:transpose){
            int stp=0 , edp=n-1;
            while(stp<edp){
                char temp=row[stp];
                row[stp]=row[edp];
                row[edp]=temp;
                stp++;
                edp--;
            }
        }

        // Step 3: Apply gravity with an optimized approach
        for (int j = 0; j < n; j++) { // Iterate column by column
            int emptyRow = m - 1; // Pointer to the next empty row for stones to fall
            for (int i = m - 1; i >= 0; i--) {
                if (transpose[i][j] == '*') {
                    // If obstacle, reset the empty pointer to one row above
                    emptyRow = i - 1;
                } else if (transpose[i][j] == '#') {
                    // If stone, move it to the empty position
                    if (i != emptyRow) {
                        transpose[emptyRow][j] = '#';
                        transpose[i][j] = '.';
                    }
                    emptyRow--; // Update the empty row pointer
                }
            }
        }
        return transpose;
    }
}
