//time complexity:O(n)
//space complexity:O(n)
//**************************************************(StringBuilder)******************************************************************
class Solution {
    public int getLucky(String s, int k) {
        if(s==null || s.length()==0) return 0;
        StringBuilder str=new StringBuilder();
        for(int i=0 ;i< s.length() ;i++){
            str.append((s.charAt(i)-'a')+1);
        }
        int sum=0;
        for(char n: str.toString().toCharArray()){
            sum+=(n-'0');
        }
        for(int i=1 ;i<k;i++){
            int newSum=0;
            while(sum>0){
                newSum+=sum%10;
                sum/=10;
            }
            sum=newSum;
        }
        return sum;

    }
}
