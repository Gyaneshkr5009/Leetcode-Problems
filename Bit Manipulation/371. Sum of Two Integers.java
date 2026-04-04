class Solution {
    public int getSum(int a, int b) {
        int carry=0 , sum=0 , pos=0;
        for(int i=0 ; i<32 ;i++){
            carry += a&1;
            a = a>>1;
            carry += b&1;
            b = b>>1;
            sum = sum | (carry&1) << pos;
            pos++;
            carry = carry/2;
        }
        return sum;
    }
}
