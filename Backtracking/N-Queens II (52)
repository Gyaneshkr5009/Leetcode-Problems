class Solution {
    private int cnt=0;
    public int totalNQueens(int n) {
        if(n==0) return cnt;
        List<String> board =new ArrayList<>();
        for(int i=0 ;i< n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0 ;j<n; j++){
                sb.append('.');
            }
            board.add(sb.toString());
        }
        solve(board , 0);
        return cnt;
    }
    private void solve(List<String> board , int row){
        if(row >= board.size()){
            cnt++;
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
