class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        if(s==null || s.length()==0) return "";
        int n=s.length();

        StringBuilder sb=new StringBuilder();
        int cumulativeShift=0;
        //traversing in reverse order;
        for(int i=n-1 ;i>=0 ;i--){
            cumulativeShift+=(shifts[i]%26);

            int ascii=(s.charAt(i) - 'a' + cumulativeShift)%26;
            sb.append((char)(ascii+'a'));
        }
        return sb.reverse().toString();
    }
}
