class Solution {
    public int totalFruit(int[] fruits) {
        int l=0;
        int r=0;
        int window=0;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        while(r<fruits.length){
            mpp.put(fruits[r] , mpp.getOrDefault(fruits[r] , 0)+1);
            while(mpp.size()>2){
                mpp.put(fruits[l] , mpp.get(fruits[l])-1);
                if(mpp.get(fruits[l])==0){
                    mpp.remove(fruits[l]);
                }
                l++;
            }
            window=Math.max(window, r-l+1);
            r++;
        }
        return window;
    }
}
