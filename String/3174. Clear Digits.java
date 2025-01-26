class Solution {
    public String clearDigits(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0 ;i<s.length() ;i++){
            char ch=s.charAt(i);
            if(ch- '0' >=0 && ch-'0'<=9){
                sb.setLength(sb.length()-1);
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
