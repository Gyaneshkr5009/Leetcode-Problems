class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        aliceIncome=Integer.MIN_VALUE;
        for(int[] edge:edges){
            adj.computeIfAbsent(edge[0] , k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1] , k -> new ArrayList<>()).add(edge[0]);
        }
        //now we have to fill the bobMap using dfs Traversal;
        boolean[] visited=new boolean[n];
        dfsBob(bob , visited , 0);

        //dfs for Alice to calculate cost;
        int totalProfit=0;
        Arrays.fill(visited , false);
        dfsAlice(0 , 0 , totalProfit , visited , amount);
        return aliceIncome;
    }

    private boolean dfsBob(int curr , boolean[] visited , int time){
        visited[curr]=true;
        bobMap.put(curr, time);

        if(curr==0) return true;

        for(int nebr:adj.getOrDefault(curr, new ArrayList<>())){
            if(!visited[nebr]){
                if(dfsBob(nebr , visited , time+1)) return true;
            }
        }
        bobMap.remove(curr);
        return false;
    }
    private void dfsAlice(int curr , int time , int total , boolean[] visited , int[] amount){
        visited[curr]=true;
        if(!bobMap.containsKey(curr) || time<bobMap.get(curr)) total+=amount[curr];
        else if(time == bobMap.get(curr)){
            total+=(amount[curr]/2);
        }
        if (adj.getOrDefault(curr, new ArrayList<>()).size() == 1 && curr != 0) {
            aliceIncome = Math.max(aliceIncome, total);
        }

        for(int nebr:adj.getOrDefault(curr, new ArrayList<>())){
            if(!visited[nebr]){
                dfsAlice(nebr , time+1 ,total , visited , amount);
            }
        }
    }
    private Map<Integer , List<Integer>> adj=new HashMap<>();
    private Map<Integer , Integer> bobMap=new HashMap<>();
    private int aliceIncome;
}
