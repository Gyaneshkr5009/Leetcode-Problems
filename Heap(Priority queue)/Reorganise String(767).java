class Solution {
    public String reorganizeString(String s) {
        //for understanding this please refer leetcode problem 1405;
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>((x,y) -> y.freq-x.freq);
        for(int i=0;i<26 ;i++){
            if(freq[i]>0) pq.offer(new Pair(freq[i] , (char)(i+(int)'a')));
        }

        StringBuilder sb=new StringBuilder();

        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int currCnt=pair.freq;
            char currCh=pair.ch;

            if(sb.length()>=1 && sb.charAt(sb.length()-1)==currCh){
                if(pq.isEmpty()) return "";
                
                Pair next=pq.poll();
                int nextCnt=next.freq;
                char nextCh=next.ch;

                nextCnt--;
                sb.append(nextCh);

                if(nextCnt>0) pq.offer(new Pair(nextCnt , nextCh));
            }
            else{
                currCnt--;
                sb.append(currCh);
            }
            if(currCnt>0) pq.offer(new Pair(currCnt , currCh));
        }
        return sb.toString();
    }

}
class Pair{
    int freq;
    char ch;
    Pair(int f, char ch){
        this.freq=f;
        this.ch =ch;
    }
}
