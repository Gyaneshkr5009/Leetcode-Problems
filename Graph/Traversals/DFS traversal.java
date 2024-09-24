//time complexity:O(n) + O(2*E);         where 2*E is the total degree of graph
//space complexity:O(3*n);
//*********************************************************(stack approach)************************************************************************
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        st.add(0);
        while (!st.isEmpty()) {
            int curr = st.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                list.add(curr);
                for (int i = adj.get(curr).size() - 1; i >= 0; i--) {
                    int e = adj.get(curr).get(i);
                    if (!visited[e]) {
                        st.push(e); 
                    }
                }
            }
        }
        return list;
    }
}


//*******************************************************(most used Recursion approach)********************************************************************
//time complexity : same as above
//space complexity : O(2n)

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited=new boolean[V];
        ArrayList<Integer> dfs=new ArrayList<>();
        visited[0]=true;
        Dfs(0 , visited , adj , dfs);
        return dfs;
    }
    public void Dfs(int node,boolean[] visited ,  ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> ls){
        visited[node]=true;
        ls.add(node);
        for(int num : adj.get(node)){
            if(visited[num] == false){
                Dfs(num , visited , adj , ls);
            }
        }
    }
}
