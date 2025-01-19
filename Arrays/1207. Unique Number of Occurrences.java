class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i:arr){
            mpp.put(i , mpp.getOrDefault(i , 0)+1);
        }
        int[] freq=new int[1001];
        for(int key:mpp.keySet()){
            freq[mpp.get(key)]++;
            if(freq[mpp.get(key)]>1) return false;
        }
        return true;
    }
}

//**********************************************(optimized approach)*************************
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] freq=new int[2001];
        for(int i:arr) freq[i+1000]++;

        boolean[] checked=new boolean[1001];

        for(int i:arr){
            int c=freq[i+1000];
            freq[i+1000]=0;
            if(c>0 && checked[c]) return false;
            checked[c]=true;
        }
        return true;
    }
}
