// Algo Used: Topological sort using BFS (also know as Kahn's algo)
// Steps for solution:
// Step 1:Converting our input into Adj
// Step 2: Marking indegree of nodes
// Step 3: Getting the nodes with 0 in-degree and adding it in queue
// Step 4: Our Main BFS until !q.isEmpty() -> keep on unmarking the indegrees of a node -> if in-degree becomes 0 then add it in queue and when it turns come in next iteration, it willl be added in the topo list.
// Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.
// Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the indegree array, and O(N) for the queue data structure used in BFS(where N = no.of nodes). Extra O(N) for storing the topological sorting.
// Total ~ O(3N).
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
