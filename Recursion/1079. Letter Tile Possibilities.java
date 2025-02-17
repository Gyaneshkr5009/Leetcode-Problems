class Solution {
    private int total=0;
    public int numTilePossibilities(String tiles) {
        int[] letters=new int[26];
        for(char ch:tiles.toCharArray()) letters[ch-'A']++;
        findSequences(letters);
        return total-1; // as we also calculated empty string;
    }
    private void findSequences(int[] letters){
        total++;
        for(int i=0;i<26;i++){
            if(letters[i]!=0){
                letters[i]--;
                findSequences(letters);
                letters[i]++;
            } 
        }
    }
}
