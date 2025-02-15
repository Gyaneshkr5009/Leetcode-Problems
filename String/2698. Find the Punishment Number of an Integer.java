class Solution {
    public int punishmentNumber(int n) {
        int result=0;
        if(n==1) return 1;
        for(int i=1 ; i<=n;i++){
            int sqrt=i*i;
            String s=Integer.toString(sqrt);
            if(check(0 , 0 , s, i)) result+=sqrt;
        }
        return result;
    }
    private boolean check(int idx , int currSum , String s, int num){
        if(idx==s.length()){
            return currSum==num;
        }
        if(currSum>num) return false;

        boolean possible=false;
        for(int j=idx;j<s.length() ;j++){
            String sub=s.substring(idx , j+1);
            int val=Integer.parseInt(sub);

            possible= possible || check(j+1 , currSum+val , s , num);
            if(possible) return true;
        }
        return false;
    }
}
