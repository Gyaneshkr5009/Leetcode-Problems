//***************************************************************(Brute Force)**************************************************************
class Solution {
    private List<String> Ips=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12 || s.length() < 4) return Ips;

        int parts=0;
        String curr="";
        helper(s, 0 , parts , curr);
        return Ips;
    }
    private void helper(String s , int idx , int parts , String curr){
        int n=s.length();
        if(idx==n && parts==4){
            Ips.add(curr.substring(0 , curr.length()-1));
            return;
        }else if(parts>=4) return ;
        //placing '.' after one character, and further checking through recursion;
        if(idx+1 <= n && isValid(String.valueOf(s.charAt(idx)))) 
                    helper(s, idx+1 , parts+1 , curr+s.charAt(idx)+'.');
        //placing '.' after two character, and further checking through recursion;
        if(idx+2 <= n && isValid(s.substring(idx , idx+2)))
                    helper(s, idx+2 , parts+1 , curr+s.substring(idx , idx+2)+'.');
        //placing '.' after three character, and further checking through recursion;
        if(idx+3 <=n && isValid(s.substring(idx , idx+3)))
                    helper(s, idx+3 , parts+1 , curr+s.substring(idx, idx+3)+'.');
    }
    private boolean isValid(String subStr ){
        int num=Integer.parseInt(subStr);
        //if the number leaded by 0;
        if(subStr.charAt(0)=='0' && subStr.length()>1) return false;
        //if substr lies between 0 to 255 then valid
        else if(num<0 || num>255) return false;
        return true;
    }
}
//*****************************************************************(optimized approach)***********************************************
class Solution {
    private List<String> Ips=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12 || s.length() < 4) return Ips;

        int parts=0;
        StringBuilder sb=new StringBuilder();
        helper(s, 0 , parts , sb);
        return Ips;
    }
    private void helper(String s , int idx , int parts , StringBuilder curr){
        int n = s.length();
        
        // Base case: if we reach the end of the string and have 4 parts, add the result.
        if (idx == n && parts == 4) {
            Ips.add(curr.substring(0, curr.length() - 1));  // Remove last dot
            return;
        }
        
        // If we already have 4 parts, return as we cannot add more parts.
        if (parts >= 4) return;
        
        // Try 1 to 3 digits for each part
        for (int len = 1; len <= 3; len++) {
            if (idx + len > n) break;
            
            String part = s.substring(idx, idx + len);
            
            if (isValid(part)) {
                int currLength = curr.length();
                curr.append(part).append('.');
                helper(s, idx + len, parts + 1, curr);
                curr.setLength(currLength);  // Backtrack
            }
        }
    }
    private boolean isValid(String subStr ){
        int num=Integer.parseInt(subStr);
        //if the number leaded by 0;
        if(subStr.charAt(0)=='0' && subStr.length()>1) return false;
        //if substr lies between 0 to 255 then valid
        return num>=0 && num<=255;
    }
}
