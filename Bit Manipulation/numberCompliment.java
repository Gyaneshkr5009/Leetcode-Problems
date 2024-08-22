//    Time Complexity :O(1)
//    Space Complexity:O(1)
***********************************************************************************************************************************************
// 1st approach 1) geting the length of bit of num    b) left shift the length of num_bits time   c) subtracting -1 will give the 1111 series    d) taking xor with the mask will give us the compliment; 

  
  class Solution {
    public int findComplement(int num) {
        int num_bits=(int)(Math.log(num)/Math.log(2)+1);

        int mask=(1<<num_bits)-1; // 1<2 => 100 similarly (1 to numbits time shift) 10000=16 -1=>1111=15
        return num^mask;
    }
}

*********************************************************************************************************************************************
  //    Time Complexity :O(1)
//    Space Complexity:O(1)

  public int findComplement(int num) {
        int num_bits=(int)(Math.log(num)/Math.log(2)+1);

        for(int i=0 ;i<num_bits; i++){
            num=num^(1<<i);
        }
        return num;
    }
