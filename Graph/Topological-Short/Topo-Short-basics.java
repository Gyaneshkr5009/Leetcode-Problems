//refer your notes to revise it again;
//*************************************************************************************************************************************
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        if(adj==null || adj.size()==0) return new int[0];
        boolean[] visited=new boolean[V];
        
        Stack<Integer> topoShort=new Stack<>();
        
        for(int i=0;i< V ;i++){
            if(visited[i]==false){
                dfs(i , adj , visited , topoShort);
            }
        }
        int[] ans=new int[V];
        for(int i=0;i<V;i++) ans[i]=topoShort.pop();
        return ans;
    }
    
    static void dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean[] visited , Stack<Integer> st){
        visited[node]=true;
        
        for(int a:adj.get(node)){
            if(visited[a]==false){
                dfs(a , adj , visited , st);
            }
        }
        st.push(node);
    }
}
