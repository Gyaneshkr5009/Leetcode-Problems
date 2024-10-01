/* approach=>
              Adjacency List: Create an adjacency list from the edges, where each edge represents a prerequisite relationship.
              In-degree Calculation: Maintain an in-degree array to track the number of incoming edges for each course.
              Queue for Zero In-degree: Initialize a queue with nodes that have zero in-degrees (no prerequisites).
              Topological Sort: Process nodes in the queue, adding them to the result array and reducing in-degrees of connected nodes. If all courses are processed, return the order; otherwise, return an empty array.
*/

//Time Complexity: O(V + E)
//Space Complexity: O(V)
//************************************************************************************************************************************************
class Solution {
    public int[] findOrder(int numCourses, int[][] edges) {
        int[] topoShort=new int[numCourses];

        //first we create an adj ArrayList where prerequisites as edges shows bond between two subjects;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0 ;i<numCourses ;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0 ;i < edges.length ;i++){
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        //now we are creating indegree to store all indegrees(means no nodes directed to current node);
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses ;i++){
            for(int a:adj.get(i)){
                indegree[a]++;
            }
        }

        //add those nodes where no one pointed means (having 0 indegree);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0 ; i<numCourses ;i++){
            if(indegree[i]==0) q.offer(i);
        }

        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            topoShort[i++]=node;
            for(int a:adj.get(node)){
                indegree[a]--;
                if(indegree[a]==0) q.offer(a);
            }
        }

        //agar Ind is not equal which means its impossible to create order of courses;
        if (i == numCourses) {
            return topoShort; // Return the valid order
        }

        return new int[0];
    }
}
//********************************************************(optimized approach using dequee and small changes)*****************************************************************
class Solution {
    public int[] findOrder(int numCourses, int[][] edges) {
        int[] topoShort = new int[numCourses];
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        
        // initialize adjacency list and indegree array
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        //now we are creating indegree to store all indegrees(means no nodes directed to current node);
         for (int[] edge : edges) {
            int u = edge[1], v = edge[0];
            adj[u].add(v);
            indegree[v]++;
        }

        //add those nodes where no one pointed means (having 0 indegree);
        Deque<Integer> q=new LinkedList<>();
        for(int i=0 ; i<numCourses ;i++){
            if(indegree[i]==0) q.offer(i);
        }

        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            topoShort[i++]=node;
            for(int a:adj[node]){
                indegree[a]--;
                if(indegree[a]==0) q.offer(a);
            }
        }

        //agar Ind is not equal which means its impossible to create order of courses;
        if (i == numCourses) {
            return topoShort; // Return the valid order
        }

        return new int[0];
    }
}
