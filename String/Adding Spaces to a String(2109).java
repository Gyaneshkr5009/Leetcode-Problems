//time complaxity:O(n+m) ,  where (n) is the length of string and (m) is the length of spaces;
//space complexity :O(n+m) ; saame reason;
//***************************************************************************************************************
class Solution {
    public String addSpaces(String s, int[] spaces) {
        if(spaces.length==0 || spaces==null) return s;
        StringBuilder sb=new StringBuilder();
        HashSet<Integer> hs=new HashSet<>();
        for(int idx:spaces) hs.add(idx);

        for(int i=0;i<s.length() ; i++){
            if(hs.contains(i)) sb.append(' ');
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

//**************************************************(optimized approach)*********************************************8
//time complexity:O(n+m);
//space complexity:O(n+m);

class Solution {
    public String addSpaces(String s, int[] spaces) {
        if(spaces == null || spaces.length==0) return s;

        StringBuilder sb=new StringBuilder();
        int spaceIdx=0;
        for(int i=0;i<s.length() ;i++){
            if(spaceIdx<spaces.length && i==spaces[spaceIdx]){
                sb.append(' ');
                spaceIdx++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
//*************************************************************(optimized approach with reduced overhead)*************************************
//overheadd means the extra work done by the DS to continue work eg ArrayList, StringBuilder , their internal structure resize them when they run out of space creating new List or sb that copies all items;
//time and space complexity are same as for above two;
class Solution {
    public String addSpaces(String s, int[] spaces) {
        if (spaces == null || spaces.length == 0) return s;

        char[] result = new char[s.length() + spaces.length];
        int spaceIdx = 0, resultIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            // Add a space at the required index
            if (spaceIdx < spaces.length && i == spaces[spaceIdx]) {
                result[resultIdx++] = ' ';
                spaceIdx++;
            }
            // Add the current character
            result[resultIdx++] = s.charAt(i);
        }

        return new String(result);
    }
}
