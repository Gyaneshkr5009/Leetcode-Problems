//time complexity: O(n) : space complexity;
class Solution {
    public String removeStars(String s) {
        int n=s.length();
        if(s==null || n==0) return "";
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<n){
            char ch=s.charAt(i);
            if(ch=='*'){
                int length=sb.length();
                sb.setLength(length-1);
            }else{
                sb.append(ch);
            }
            i++;
        }
        return sb.toString();
    }
}
//*******************************************(optimized approach)*************************************************
class Solution {
    public String removeStars(String s) {
        int n=s.length();
        if(s==null || n==0) return "";
        char[] result=new char[n];
        int j=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='*'){
                j--;
            }
            else{
                result[j++]=ch;
            }
        }
        return new String(result , 0 , j);
    }
}
