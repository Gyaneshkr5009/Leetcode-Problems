class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        if (words == null || words.length == 0) return 0;
        int n = words.length, cnt = 0;
        
        for (int i = 0; i < n - 1; i++) {
            String word = words[i];
            for (int j = i + 1; j < n; j++) {
                if (words[j].startsWith(word) && words[j].endsWith(word)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
