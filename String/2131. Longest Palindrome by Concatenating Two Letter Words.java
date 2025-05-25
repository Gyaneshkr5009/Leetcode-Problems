class Solution {
    public int longestPalindrome(String[] words) {
        Map<String , Integer> mpp= new HashMap<>();
        for(String word : words){
            mpp.put(word , mpp.getOrDefault(word , 0)+1);
        }

        int length=0;
        boolean centerUsed=false;

        for(String word : mpp.keySet()){
            String reverse = new StringBuilder(word).reverse().toString();

            //if the reverse one look same then 
            if(word.equals(reverse)){
                int freq= mpp.get(word);
                int pairCnt = freq/2;
                length += pairCnt*4;
                mpp.put(word , freq%2);

                if(!centerUsed && mpp.get(word) > 0){
                    length+=2;
                    centerUsed=true;
                }
            }
            else{
                if(mpp.containsKey(reverse)){
                    int pairCnt = Math.min(mpp.get(word) , mpp.get(reverse));
                    length += pairCnt * 4; //as both contains 2 element so one pair becomes 4 length of characters;
                    mpp.put(word , mpp.get(word) - pairCnt);
                    mpp.put(reverse , mpp.get(reverse) - pairCnt);
                }
            }
        }
        return length;
    }
}
