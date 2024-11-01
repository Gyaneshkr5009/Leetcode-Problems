class Solution {
    public String makeFancyString(String s) {
        if(s==null || s.length()==0) return "";

        StringBuilder sb=new StringBuilder();
        int cnt=1;
        sb.append(s.charAt(0));

        char prev=s.charAt(0);

        for(int i=1 ;i< s.length() ;i++){
            char curr=s.charAt(i);
            if(prev==curr){
                cnt++;
            }
            else cnt=1;
            if(cnt<3){
                sb.append(curr);
            }
            prev=curr;
        }
        return sb.toString();
    }
}
