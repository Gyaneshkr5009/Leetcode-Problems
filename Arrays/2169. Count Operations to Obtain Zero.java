class Solution {
    int ans=0;
    public int countOperations(int num1, int num2) {
        if(num1 == 0 || num2==0) return 0;

        if(num1 >= num2) {
            ans+=num1/num2;
            countOperations(num1 - (num1/num2)*num2 , num2);
        }
        else {
            ans+=num2/num1;
            countOperations(num1 , num2 - (num2/num1)*num1);
        }
        return ans;
    }
}
