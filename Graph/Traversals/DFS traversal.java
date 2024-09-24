//time complexity:O(n) + O(2*E);         where 2*E is the total degree of graph
//space complexity:O(3*n);
//*********************************************************************************************************************************
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
