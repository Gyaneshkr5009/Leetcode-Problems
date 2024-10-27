/*
      Purpose: The method finds the minimum number of edges required to make all nodes in a graph connected. If enough extra edges aren’t available, it returns -1.

      Extra Edges Count: During the edge processing, if both endpoints of an edge share the same ultimate parent (already connected indirectly), the edge is counted as extra. Otherwise, the nodes are connected by rank or size.
      
      Component Count: After processing edges, it counts components by checking if each node is its own parent, indicating separate connected components.
      
      Edge Requirement: To connect all components, the minimum required edges are (components - 1). If extra edges meet or exceed this requirement, it returns this value; otherwise, -1.
      
      Union by Rank/Size: The DisjointSet class allows for efficient union operations, reducing tree depth (by rank) or balancing component size (by size).
*/
//Time Complexity: O(E⋅α(V)), where EE is the number of edges and VV is the number of nodes (with αα as the inverse Ackermann function for DSU operations).
//Space Complexity: O(V) for the parent, rank, and size arrays in DisjointSet.
//*******************************************************(DisjointSet)*******************************************************
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int cntExtras=0; // this will store the cnt of all extra edges;
        for(int[] edges: connections){
            int u=edges[0];
            int v=edges[1];
            //an edge where both u and v have same ulp means its an extra edge that directly connects u and v;
            // eg u--g--v  : ulp(u)->g  : ulp(v)-> g  , so (u & v) can connect via g then why direct cnt as extra;
            if(ds.findUPar(u) == ds.findUPar(v)) cntExtras++;
            else ds.unionByRank(u , v);
        }
        int cntComponents=0;
        for(int i=0;i<n ;i++){
            if(ds.parent.get(i)==i) cntComponents++;
        }
        //we know min to connect all n nodes is (n-1) edges , so components-1 is the min edge to connect all component;
        int ans=cntComponents-1;
        if(cntExtras>=ans) return ans;
        return -1;
    }
}

class DisjointSet{
    ArrayList<Integer> parent =new ArrayList<>() , rank=new ArrayList<>() ,size=new ArrayList<>();
    //v tends to no of nodes;
    DisjointSet(int V){
        for(int i=0;i<V ;i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    //finding the ultimate parent of a node;(ultimate parent means that doesnt have parent);
    int findUPar(int node){
        if(node==parent.get(node)) return node;

        int ulp=findUPar(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);
    }

    void unionByRank(int u , int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        //if both ultimate parent are same means they both part of a single component;
        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
        }
        else if (rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v , ulp_u);
        }
        else{
            parent.set(ulp_v , ulp_u);
            rank.set(ulp_u , rank.get(ulp_u)+1);
        }
    }
    void unionBySize(int u , int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
