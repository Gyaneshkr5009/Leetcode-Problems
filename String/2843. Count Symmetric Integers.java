class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt=0;
        for(int i=low;i<=high;i++){
            //converting the number into String
            String sb=String.valueOf(i);
            //if digits in a number not divisible by two means not a symmatric , so move on to next number
            if(sb.length()%2!=0) continue;
            int left=0 , right=sb.length()-1;
            int sum=0 ,revSum=0;
            while(left<right){
                sum+=sb.charAt(left++);
                revSum+=sb.charAt(right--);
            }
            if(sum==revSum) cnt++;
        }
        return cnt;
    }
}
