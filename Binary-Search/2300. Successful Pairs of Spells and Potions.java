class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m=potions.length , n=spells.length;

        int[] ans=new int[n];
        Arrays.sort(potions);
        for(int i=0;i<n;i++){
            int left=0 , right=m-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if((long)spells[i]*potions[mid]>=success){
                    right=mid-1;
                }
                else left=mid+1;
            }
            ans[i]=m-right-1;
        }
        return ans;
    }
}
