
//****************************************************************************(optimal approach)*********************************************************
class Solution {
    public int findCircleNum(int[][] isConnected) {
        if(isConnected.length==0) return 0;
        int n=isConnected.length;
        int m=isConnected[0].length;
        int ans=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                ans++;
                dfs(isConnected , visited ,i);
            }
        }
        return ans;
    }
    public void dfs(int[][] arr , boolean[] visited , int i){
        if(visited[i]) return;
        visited[i]=true;
        for(int j=0 ; j<arr[0].length;j++){
            if(arr[i][j]==1){
                dfs(arr , visited , j);
            }
        }
    }
}


//**************************************************************(2nd approach)*************************************************************
class Solution {
    public int findCircleNum(int[][] isConnected) {
        Queue<Integer> q=new LinkedList<>();
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new ArrayList<>());
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    arr.get(i).add(j);
                } 
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                q.add(i);
                visited.add(i);
                while(!q.isEmpty()){
                    int curr=q.poll();
                    for(int  j:arr.get(curr)){
                        if(!visited.contains(j)){
                            q.add(j);
                            visited.add(j);
                        }
                    }
                }
                cnt++;
            }
        }
        return cnt;
    }
}
