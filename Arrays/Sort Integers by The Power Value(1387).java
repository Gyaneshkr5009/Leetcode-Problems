//time Complexity:O(n⋅logm+nlogn)
//space complexity:O(n)
//*******************************************************************(min Heap)**********************************************************************
class Solution {
    public int getKth(int lo, int hi, int k) {
        if(lo>hi) return -1;

        Pair[] order=new Pair[hi-lo+1];
        int idx=0;
        for(int i=lo ; i<=hi ;i++){
            int num=i;
            int score=0;
            while(num!=1){
                if(num%2==0){
                    num/=2;
                }
                else if(num%2==1){
                    num=num*3+1;
                }
                score++;
            }
            order[idx++]=new Pair(i , score);
        }

        Arrays.sort(order , (a,b)-> a.score!=b.score ? a.score-b.score : a.value-b.value);
        return order[k-1].value;
    }
}
class Pair{
    int value;
    int score;
    Pair(int value , int score){
        this.value=value;
        this.score=score;
    }
}
