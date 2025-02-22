class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if(digits==null || digits.length()==0) return list;
        Map<Character , List<Character>> mpp=new HashMap<>();
        for(char ch='1'; ch<='9';ch++){
            mpp.put(ch , new ArrayList<>());
        }
        mpp.put('2' , Arrays.asList('a' , 'b' , 'c'));
        mpp.put('3', Arrays.asList('d' , 'e' , 'f'));
        mpp.put('4', Arrays.asList('g' , 'h' , 'i'));
        mpp.put('5', Arrays.asList('j' , 'k' , 'l'));
        mpp.put('6', Arrays.asList('m' , 'n' , 'o'));
        mpp.put('7', Arrays.asList('p' , 'q' , 'r' , 's'));
        mpp.put('8', Arrays.asList('t' , 'u' , 'v'));
        mpp.put('9', Arrays.asList('w' , 'x' , 'y' , 'z'));
        
        StringBuilder sb=new StringBuilder();
        solve(digits , mpp , list , 0 , sb);
        return list;
    }
    private void solve(String digits , Map<Character , List<Character>> mpp , List<String> ls , int idx , StringBuilder sb){
        if(idx >= digits.length()){
            ls.add(sb.toString());
            return;
        }
        for(char ch:mpp.get(digits.charAt(idx))){
            sb.append(ch);
            solve(digits , mpp , ls , idx+1 , sb);
            sb.deleteCharAt(sb.length()-1); //backtrack;
        }
    }
}
