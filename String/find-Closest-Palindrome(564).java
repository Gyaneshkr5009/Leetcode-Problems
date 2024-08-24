Time Complexity: O(l), where l is the length of the string n.
Space Complexity: O(l).

******************************************************************************************************************************************
class Solution {
    public String nearestPalindromic(String n) {
        int l=n.length();
        int mid=l/2;
        int firstHalfLength= (l%2==0)?mid:mid+1;
        long firstHalf=Long.parseLong(n.substring(0 , firstHalfLength));

        ArrayList<Long> possibleSol=new ArrayList<>();
        possibleSol.add(palindrome(firstHalf , l%2==0));      // fuctn that takes half of string and filling
        possibleSol.add(palindrome(firstHalf + 1 , l%2==0));    //remaining t make palindrome;
        possibleSol.add(palindrome(firstHalf - 1 , l%2==0));
        possibleSol.add((long)Math.pow(10 , l)+1);      // eq 999 so pow(10^3 + 1) | nearest will be 1001; 
        possibleSol.add((long)Math.pow(10 , l-1)-1);      // eq 101 so pow(10^(3-1) - 1) | nearest will be 99;

        Long diff=Long.MAX_VALUE;
        Long res=Long.MAX_VALUE;
        Long originalNum=Long.parseLong(n);

        for(long num:possibleSol){
            if(num==originalNum) continue;
            if(Math.abs(num-originalNum)<diff){
                diff=Math.abs(num-originalNum);
                res=num;
            }
            else if(Math.abs(num-originalNum)==diff){
                res=Math.min(res,num);
            }
        }

        return res.toString();
    }

    private long palindrome(long firstHalf , boolean isEven){
        long ans=firstHalf;
        if(isEven==false){
            firstHalf/=10;
        }
        while(firstHalf>0){
            long digit=firstHalf % 10;
            ans=ans*10+digit;
            firstHalf/=10;
        }
        return ans;
    }
}
