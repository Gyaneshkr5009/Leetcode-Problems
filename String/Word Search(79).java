//time complexity:O(n*m*4^l);
//space complexity:O(l);

//*************************************************************(most optimized approach)********************************************************
// what we do we remove the visited matrix result in reducing space complexity;
// early check by calculating their freq( if not match return true, no need for recursion);
// instead of checking only from the front we parallaly check from the backward;
// all these steps result in less time and space complexity;

class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || word==null || word.length()==0) return false;
        int n=board.length;
        int m=board[0].length;

        int[] boardFreq = new int[52]; // 26 for lowercase, 26 for uppercase
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = board[i][j];
                if (Character.isUpperCase(ch)) {
                    boardFreq[ch - 'A']++;
                } else {
                    boardFreq[ch - 'a' + 26]++;
                }
            }
        }
        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                if (boardFreq[ch - 'A'] <= 0) return false;
                boardFreq[ch - 'A']--;
            } else {
                if (boardFreq[ch - 'a' + 26] <= 0) return false;
                boardFreq[ch - 'a' + 26]--;
            }
        }

        //we are searching from front;
        for(int i=0; i<n;i++){
            for(int j=0 ; j< m ;j++){
                if((board[i][j]==word.charAt(0) && dfs(board , word , 0 , i , j , n , m))
                || (board[i][j]==word.charAt(word.length()-1) && dfsBack(board , word, word.length()-1 , i , j , n , m))) return true;
            }
        }
        
        return false;
    }

    private boolean dfs(char[][] board , String word , int idx , int row, int col , int rows , int cols){
        //base case ;
        if(idx==word.length()) return true;
        if(row<0 || col<0 || row>=rows || col>=cols || board[row][col]!= word.charAt(idx)) return false;

        char temp=board[row][col];
        board[row][col]='#'; // marking as visited;

        int[] dRow={-1 , 0 , 1 ,0};
        int[] dCol={0 , 1, 0, -1};

        for(int i=0; i<4 ;i++){
            int nRow=row+dRow[i];
            int nCol=col+dCol[i];
            if(dfs(board , word, idx+1 , nRow , nCol , rows, cols)) return true;
        }
        board[row][col]=temp; // backtrack;
        return false;
    }

    private boolean dfsBack(char[][] board , String word , int idx , int row, int col , int rows , int cols){
        //base case;
        if(idx==-1) return true;
        if(row<0 || col<0 || row>=rows || col>=cols || board[row][col]!= word.charAt(idx)) return false;
        char temp=board[row][col];
        board[row][col]='#'; // marking as visited;

        int[] dRow={-1 , 0 , 1 ,0};
        int[] dCol={0 , 1, 0, -1};

        for(int i=0; i<4 ;i++){
            int nRow=row+dRow[i];
            int nCol=col+dCol[i];
            if(dfsBack(board , word, idx-1 , nRow , nCol , rows, cols)) return true;
        }
        board[row][col]=temp; // backtrack;
        return false;
    }
}


//**************************************************************************************************************************************************************
/*
    time Complexity:O(n*m*4^l)  , where l is the length of word
    space cmplexity:O(n*m+l)
*/

//************************************************************************(dfs approach)*************************************
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || word==null || word.length()==0) return false;
        int n=board.length;
        int m=board[0].length;
        boolean[][] visited=new boolean[n][m];

        for(int i=0; i<n;i++){
            for(int j=0 ; j< m ;j++){
                if(board[i][j]==word.charAt(0) && dfs(board , word , 0 , i , j , n , m , visited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board , String word , int idx , int row, int col , int rows , int cols ,boolean[][] visited){
        //base case ;
        if(idx==word.length()) return true;
        if(row<0 || col<0 || row>=rows || col>=cols || board[row][col]!= word.charAt(idx) || visited[row][col]) return false;

        visited[row][col]=true;

        int[] dRow={-1 , 0 , 1 ,0};
        int[] dCol={0 , 1, 0, -1};

        for(int i=0; i<4 ;i++){
            int nRow=row+dRow[i];
            int nCol=col+dCol[i];
            if(dfs(board , word, idx+1 , nRow , nCol , rows, cols , visited)) return true;
        }
        visited[row][col]=false;
        return false;
    }
}

//************************************************(reducing n*m size by removing visited array)*************************************************
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || word==null || word.length()==0) return false;
        int n=board.length;
        int m=board[0].length;

        for(int i=0; i<n;i++){
            for(int j=0 ; j< m ;j++){
                if(board[i][j]==word.charAt(0) && dfs(board , word , 0 , i , j , n , m)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board , String word , int idx , int row, int col , int rows , int cols){
        //base case ;
        if(idx==word.length()) return true;
        if(row<0 || col<0 || row>=rows || col>=cols || board[row][col]!= word.charAt(idx)) return false;

        char temp=board[row][col];
        board[row][col]='#'; // marking as visited;

        int[] dRow={-1 , 0 , 1 ,0};
        int[] dCol={0 , 1, 0, -1};

        for(int i=0; i<4 ;i++){
            int nRow=row+dRow[i];
            int nCol=col+dCol[i];
            if(dfs(board , word, idx+1 , nRow , nCol , rows, cols)) return true;
        }
        board[row][col]=temp; // backtrack;
        return false;
    }
}
