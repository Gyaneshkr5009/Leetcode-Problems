class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionByRank(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
            if (ds.findUPar(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }
        return n-cnt;
    }
}

class DisjointSet{
    ArrayList<Integer> parent =new ArrayList<>() , rank=new ArrayList<>() , size=new ArrayList<>();
    //v tends to no of nodes;
    DisjointSet(int V){
        for(int i=0;i<=V ;i++){
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
    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
