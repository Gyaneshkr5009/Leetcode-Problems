/* approach=>
        Adjacency List Creation: Convert the prerequisites into an adjacency list to represent the directed graph.
        In-degree Array: Track the number of incoming edges for each course (node) to identify the starting points for topological sorting.
        Queue for Zero In-degree: Perform BFS by adding nodes with zero in-degree to the queue and reducing in-degrees for their connected nodes.
        Cycle Detection: If the topological sort list contains all courses, return true (no cycle), else return false (cycle exists).
*/
//Time Complexity: O(V + E)
//Space Complexity: O(V)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();// creating our adj list
        for(int i= 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length; // converting the input prerequisites to adjList Step1
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree= new int[numCourses]; // indegree array

        for(int i=0; i< numCourses; i++){   // marking the incoming edges (incoming edges) of node node Step2
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q= new LinkedList<>();   
        ArrayList<Integer> topo= new ArrayList<>();    // topo sort list
        for(int i=0; i< numCourses; i++){   // // getting the nodes with 0 in-degree Step3
            if(indegree[i]== 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){    // doing our Topo sort BFS(Kahn's) Step4
            int node= q.poll();
            topo.add(node);
            for(int it: adj.get(node)){
                indegree[it]--; // removing the edges for the node nodes added in queue
                if(indegree[it] == 0){  // if at any point the node who are becoming 0 after decreaising then add in queue
                    q.add(it);
                }
            }
        }
        if(topo.size() == numCourses){  // if topo size is N then cycle is not present and input if DAG, else return false for cycle
            return true;
        }
        return false;
    }
}
