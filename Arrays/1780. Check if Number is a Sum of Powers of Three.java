class Solution {
    public boolean checkPowersOfThree(int n) {
        int power=(int)(Math.log(n)/Math.log(3));
        
        while(n>0){
            if(n>=Math.pow(3,power)){
                n-=Math.pow(3,power);
            }
            if(n>=Math.pow(3,power)) return false;
            power--;
        }
        return true;
    }
}
