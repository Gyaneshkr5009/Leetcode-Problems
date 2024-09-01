//time complexity:O(n)
//space complexity:O(n)
//**********************************************************************************************************************
class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        if(queries==null || queries.length==0 || k==0) return new int[]{};
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int[] ans=new int[queries.length];
        Arrays.fill(ans,-1);
        if(queries.length<k ) return ans;
        for(int i=0 ;i<queries.length ;i++){
            int x=queries[i][0];
            int y=queries[i][1];
            int val=Math.abs(x)+Math.abs(y);
            if(pq.size()<k){
                pq.offer(val);
            }
            else if(val<pq.peek()){
                pq.poll();
                pq.offer(val);
            }
            if(pq.size()<k){
                ans[i]=-1;
            }
            else{
                ans[i]=pq.peek();
            }
        }
        return ans;
    }
}
