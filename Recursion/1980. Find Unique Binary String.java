
//*******************************************(cantor's theorem)*******************************
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        //000=0 , 001=1 , 010=2 , 011=3 and so on ;
        //to find the string we move binary wise;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<nums.length;i++){
            if(nums[i].charAt(i)=='0'){
                sb.append('1');
            }
            else sb.append('0');
        }
        return sb.toString();
    }
}

//********************************************************************************************888
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        Set<String> st=new HashSet<>();
        for(String str:nums) st.add(str);
        StringBuilder sb=new StringBuilder();
        return helper(n ,st , sb);
    }
    private String helper(int n , Set<String> st , StringBuilder sb){
        if(sb.length()==n){
            if(!st.contains(sb.toString())) return sb.toString();
            return null;
        }
        for(char i='0' ;i<='1' ;i++){
            sb.append(i);
            String result=helper(n, st,sb);
            if(result!=null) return result;
            sb.deleteCharAt(sb.length()-1); // backtrack;
        }
        return null;
    }
}
