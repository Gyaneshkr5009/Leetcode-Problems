class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits==null || digits.length()==0) return result;

        HashMap<Character, String> keyboard=new HashMap<>();
        keyboard.put('2' , "abc");
        keyboard.put('3' , "def");
        keyboard.put('4' , "ghi");
        keyboard.put('5' , "jkl");
        keyboard.put('6' , "mno");
        keyboard.put('7' , "pqrs");
        keyboard.put('8' , "tuv");
        keyboard.put('9' , "wxyz");
        backtrack(digits , 0 , new StringBuilder() , result , keyboard);
        return result;
    }
    private void backtrack(String digits , int idx, StringBuilder combination , List<String> result , HashMap<Character , String> keyboard){
        if(idx==digits.length()){
            result.add(combination.toString());
            return;
        }

        String letter=keyboard.get(digits.charAt(idx));
        for(char ch:letter.toCharArray()){
            combination.append(ch);
            backtrack(digits , idx+1 , combination , result , keyboard);
            combination.deleteCharAt(combination.length()-1);
        }
        
    }
}
