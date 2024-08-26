time complexity:O(n);
space complexity:O(n);

//**********************************************************************************************************************************************
class Solution {
    public boolean rotateString(String s, String t) {
        if(s.length() != t.length()) return false;  // if 2 String are not equal in size rotation not possible;
        //storing the first element of string then finding all indexes of that char on another string
        char firstChar=s.charAt(0);
        ArrayList<Integer> indexes=new ArrayList<>(); // for storing all indexes;
        for(int i=0 ;i< s.length()  ;i++){
            if(t.charAt(i)==firstChar){
                indexes.add(i);
            }
        }
        for(int idx:indexes){
            if(rotation(s , t , idx)) return true; // fuctn call that gives true or false if rotation happens;
        }
        return false;
    }

    private boolean rotation(String s, String t , int idx){
        for(int i=0 ;i<t.length() ;i++){
            if(s.charAt(i) != t.charAt((idx+i)%t.length())) return false;
        }
        return true;
    }
}
