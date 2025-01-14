//time complexity:O(n+m);
//time complexity:O(1); as i use 402 lengh of array;
//****************************************************************************************************************
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n=s.length() , m=t.length();        
        if(s==null || n==0 || m==0) return false;
        char[] result=new char[402];
        
        int j=0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '#') {
                if(j>0) j--; 
            } else {
                result[j++] = ch; 
            }
        }
        int k=201;
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            if (ch == '#') {
                if(k>201) k--; 
            } else {
                result[k++] = ch;  
            }
        }
        return (new String(result, 0, j).equals(new String(result, 201, k - 201)));
    }
}
