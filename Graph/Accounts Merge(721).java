
//************************************************************(disjoint Set)******************************************************************
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        Map<String , Integer> mpp=new HashMap<>();
        //we divide whole accounts list acc to index  eg: accounts 1 list have parent 0 then 2nd one has 1 and so on;
        DisjointSet ds=new DisjointSet(n);

        List<List<String>> ans=new ArrayList<>(); // this is created to store all merged List;

        //now we store all string to their index ( parent) and store it into hashmap and when we encounter a string whose parent is already declared in hashmap ,we unionBySize;
        for(int i=0;i<n ;i++){
            for(int j=1;j<accounts.get(i).size(); j++){
                String mail=accounts.get(i).get(j);
                if(!mpp.containsKey(mail)) mpp.put(mail , i);
                else{
                    ds.unionBySize(i , mpp.get(mail));
                }
            }
        }

        ArrayList<String>[] mergeMail = new ArrayList[n];
        for(int i=0;i< n;i++){
            mergeMail[i]=new ArrayList<String>();
        }

        for(Map.Entry<String , Integer> entry: mpp.entrySet()){
            String mail=entry.getKey();
            int node=ds.findUPar(entry.getValue());
            mergeMail[node].add(mail);
        }


        for(int i=0 ;i < n ;i++){
            if(mergeMail[i].size()==0) continue;
            Collections.sort(mergeMail[i]);
            List<String> ls=new ArrayList<>();
            ls.add(accounts.get(i).get(0));
            for(String it:mergeMail[i]){
                ls.add(it);
            }
            ans.add(ls);
        }
        return ans;
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
