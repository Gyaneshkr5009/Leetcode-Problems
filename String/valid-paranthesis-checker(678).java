  //time complexity: O(n)
//space complexity:O(n)

*****************************************************************************************
class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openBr=new Stack<>();
        Stack<Integer> star=new Stack<>();
        for(int i=0 ; i< s.length() ;i++){
            char c=s.charAt(i);
            if(c=='(') openBr.push(i);
            else if(c=='*') star.push(i);
            else if(c==')'){
                if(!openBr.isEmpty()) openBr.pop();
                else if(!star.isEmpty()) star.pop();
                else if(openBr.isEmpty() && star.isEmpty()) return false;
            }
        }
        while(!openBr.isEmpty() && !star.isEmpty()){
            if(star.pop()<openBr.pop()) return false;
        }
        return openBr.isEmpty();
    }
}
