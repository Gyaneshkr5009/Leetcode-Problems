//time complexity:O(n);
//spaace complexity:O(n);
//***************************************************************************************************************
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        String[] ans=new String[names.length];
        int idx=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer,String> mpp=new HashMap<>();
        for(int i=0 ;i<names.length;i++){
            mpp.put(heights[i] , names[i]);
            pq.offer(heights[i]);
        }
        while(!pq.isEmpty()){
            ans[idx++]=mpp.get(pq.poll());
        }
        return ans;
    }
}

//*******************************************(optimal approach)******************************************************
//time cmplexity:O(n);
//space complexity:O(n);

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        String[] ans=new String[names.length];
        int idx=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b) ->  b.height-a.height // sort the order in decresing;
        );
        for(int i=0;i<names.length ;i++){
            pq.offer(new Pair(names[i],heights[i]));
        }
        while(!pq.isEmpty()){
            ans[idx++]=pq.poll().name;
        }
        return  ans;

    }
}
class Pair{
    String name;
    int height;
    Pair(String name ,int height){
        this.name=name;
        this.height=height;
    }
}
