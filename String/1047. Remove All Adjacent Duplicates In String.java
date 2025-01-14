//time complexity:O(n) : space complexity
//*******************************************************************************************************************************
class Solution {
    public String removeDuplicates(String s) {
        int n=s.length();
        char[] result=new char[n];

        int j=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(j>0 && ch==result[j-1]){
                j--;
                result[j]='\0'; //reseting to default value;
            }
            else{
                result[j++]=ch;
            }
        }
        return new String(result , 0 , j);
    }
}
