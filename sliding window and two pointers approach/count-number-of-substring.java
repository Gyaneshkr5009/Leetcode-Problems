//time complexity:O(n);
//space complexity:O(k);
//***********************************************************************************************************************************************************
class Solution
{
    long substrCount (String str, int k) {
        return count(str,k)-count(str,k-1);
    }
    long count (String str, int k) {
        long cnt = 0;
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();
        
        while (r < str.length()) {
            mpp.put(str.charAt(r), mpp.getOrDefault(str.charAt(r), 0) + 1);
            
            while (l <= r && mpp.size() > k) {
                mpp.put(str.charAt(l), mpp.get(str.charAt(l)) - 1);
                if (mpp.get(str.charAt(l)) == 0) {
                    mpp.remove(str.charAt(l));
                }
                l++;
            }
            
            cnt += r - l + 1; // Counting the number of valid substrings ending at 'r'
            r++;
        }
        
        return cnt;
    }
}
