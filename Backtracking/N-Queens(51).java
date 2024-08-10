//time complexity : O(n!)
//space complexity : O(n^2)

class Solution {
    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n==0) return result;
        List<String> board =new ArrayList<>();
        for(int i=0 ;i< n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0 ;j<n; j++){
                sb.append('.');
            }
            board.add(sb.toString());
        }
        solve(board , 0);
        return result;
    }
    private void solve(List<String> board , int row){
        if(row >= board.size()){
            result.add(new ArrayList<>(board));
            return;
        }
        for(int i=0 ; i< board.size() ; i++){
            if(isSafe(board , row , i)){
                StringBuilder newRow=new StringBuilder(board.get(row));
                newRow.setCharAt(i , 'Q');
                board.set(row , newRow.toString());
                solve(board , row+1);
                newRow.setCharAt(i , '.');
                board.set(row , newRow.toString());
            }
        }
    }
    private boolean isSafe(List<String> board , int row , int col){
        for(int i=row ; i>=0 ;i--){
            if(board.get(i).charAt(col) == 'Q')
            return false;
        }
        for(int i=row , j=col ; i>=0 && j>=0 ; i-- , j--){
            if(board.get(i).charAt(j) == 'Q') return false;
        }
        for(int i=row , j=col ; i>=0 && j<board.size() ; i-- , j++){
            if(board.get(i).charAt(j) == 'Q') return false;
        }
        return true;
    }
}
