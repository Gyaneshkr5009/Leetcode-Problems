//time complexity: E log(V) =>(E- no of Edges  ,  V- no of Nodes);
//space complexity: O(n);
//***********************************************************************(using PrioirtyQueue)*********************************************************
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        if(adj==null || adj.size()==0) return new int[0];
        //creating min Heap sorted with distance;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)-> x.distance-y.distance);
        pq.offer(new Pair(0 , S)); // inserting source node with 0 distance;
        
        //creating array that stores all shortest distance from source node;
        int[] dist=new int[V];
        Arrays.fill(dist , Integer.MAX_VALUE); // filling all node with max value;
        dist[S]=0;
        
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int node=pair.node;
            int dis=pair.distance;
            
            
            // If current distance is smaller,
            // push it into the queue.
            for(int i=0 ; i<adj.get(node).size() ;i++){
                int edgeWeight=adj.get(node).get(i).get(1);
                int adjNode=adj.get(node).get(i).get(0);
                
                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode]=dis+edgeWeight;
                    pq.offer(new Pair(dist[adjNode], adjNode));
                }
                
            }
        }
        return dist;
    }
}
class Pair{
    int node;
    int distance;
    Pair(int distance , int node){
        this.node =node;
        this.distance= distance;
    }
}
