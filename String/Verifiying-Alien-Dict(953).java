/*
    Mapping Alien Order: Create a mapping array to store the index of each character in the given alien order.
    Pairwise Comparison: Compare each consecutive pair of words, checking if the characters follow the alien dictionary order.
    Prefix Handling: Handle cases where one word is a prefix of the other (e.g., "apple" vs. "app") by ensuring the shorter word comes first.
    Return Result: If all words follow the alien order, return true; otherwise, return false.

    Time Complexity: O(N * M) (N = number of words, M = average word length)
    Space Complexity: O(1) (excluding input space)
*/

//**************************************************************(using graph alien dict concept)*****************************************************
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map=new int[26];
        //storing word into map having index;
        for(int i=0;i<order.length();i++){
            map[order.charAt(i)-'a']=i;
        }

        for(int i=0;i<words.length-1 ;i++){
            String s1=words[i];
            String s2=words[i+1];
            int length=Math.min(s1.length() , s2.length());
            //if both letters with same idx not same check if 1st one appears before 2nd one in order
            for(int idx=0;idx<length;idx++){
                if(s1.charAt(idx)!=s2.charAt(idx)){
                    if(map[s1.charAt(idx)-'a']>map[s2.charAt(idx)-'a']) return false;
                    break;
                }
            }
            //handling cases where one word is prefix of another;
            //suppose apple , app in dict [1st app , 2nd apple] so if 1st one is apple 2nd=> app means not in order false;
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return false;
            }
        }
        return true;
    }
}
