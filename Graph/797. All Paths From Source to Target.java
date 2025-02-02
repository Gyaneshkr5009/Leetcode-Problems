class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> temp=new ArrayList<>(); // creating a list that stores the sequence;
        temp.add(0); // storing the strting node;
        dfs(graph, temp , 0); //calling dfs to traverse all path and adding that list to our ans list;
        return ans;
    }
    private List<List<Integer>> ans=new ArrayList<>(); // declaring global list
    private void dfs(int[][] graph , List<Integer> temp , int currNode){
        if(currNode == graph.length-1){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        //iterating the current node neighbor 
        for(int neighbor : graph[currNode]){
            temp.add(neighbor); // adding to list so that we can get the list with this neighbor node;
            dfs(graph ,temp , neighbor); // after that removing that node so that we can check other as well;
            temp.remove(temp.size()-1); // backtrack
        }
    }
}
