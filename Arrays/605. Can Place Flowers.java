class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m=flowerbed.length;
        
        int cnt=0;
        for(int i=0;i<m;i++){
            if(flowerbed[i]==0){
                boolean prevEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean nextEmpty = (i == m - 1 || flowerbed[i + 1] == 0);
                
                if (prevEmpty && nextEmpty) {
                    flowerbed[i] = 1;
                    cnt++;
                }
            }
            if(cnt>=n) return true;
        }
        return cnt>=n?true:false;
    }
}
