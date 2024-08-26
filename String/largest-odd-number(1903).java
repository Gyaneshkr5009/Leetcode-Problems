//time complexity:O(n)
//space complexity:O(1)

/*approach we start from the end of the string if we got even we continue
  else if we got odd then we return the substring from (0 to currindex);
*/
//****************************************************()*****************************************************************************
class Solution {
    public String largestOddNumber(String num) {
        for(int i = num.length()-1 ; i>=0;i--){
            if((num.charAt(i)-'0')%2==1){
                int idx=i;
                int j=0;
                return num.substring(0 , i+1);
            }
            else if((num.charAt(i)-'0') % 2==0){
                if(i==0){
                    return "";
                }
                else continue;
            }
            break;
        }
        return "";
    }
}
