//***********************************************************************************(optimal)***********
class Solution {
    public int reverseBits(int n) {
        //after that i got the binary of n in reverse manner , so it already reversed;
        int ans=0 ;
        for(int i= 0; i < 32 ; i++){
            ans = ans << 1;
            ans = ans | n & 1;
            n= n >> 1;
        }
        return ans;
    }
}

//**********************************************************************************************
class Solution {
    public int reverseBits(int n) {
        //after that i got the binary of n in reverse manner , so it already reversed;
        int ans=0 , power = 1;
        for(int i= 0; i < 32 ; i++){
            if((n & 1 << (31 - i)) != 0){
                ans += power;
            }
            power*=2;
        }
        return ans;
    }
}
