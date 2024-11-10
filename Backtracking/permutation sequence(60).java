//*****************************************************(for understanding this go through permutation solution)************************
class Solution {
    private int cnt=0;
    private List<Integer> ans=new ArrayList<>();
    public String getPermutation(int n, int k) {
        int[] visited = new int[n + 1];
        List<Integer> ds = new ArrayList<>();
        
        // Start the recursive helper function with initial values
        helper(n, ds, visited, k);
        
        StringBuilder sb = new StringBuilder();
        for (int a : ans) {
            sb.append(a);
        }
        return sb.toString();
    }
    private void helper(int n , List<Integer> ds , int[] visited,  int k){
        if(ds.size()==n){
            cnt++;
            if(cnt==k) ans=new ArrayList<>(ds);
            return;
        }

        for(int i=1;i<=n;i++){
            if(visited[i]==0){
                visited[i]=1;
                ds.add(i);
                helper(n , ds , visited , k);
                //if we already found our pwemutation simple return;
                if(ans.size()!=0) return;
                ds.remove(ds.size()-1); //removing last added element;
                visited[i]=0; // backtrack;
            }
        }
    }
}
