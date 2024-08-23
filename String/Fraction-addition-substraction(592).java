
  Time Complexity:O(n)
  Space Complexity:O(1)


***************************************************************************************************************************************************************8
class Solution {
    public String fractionAddition(String expression) {
        int numerator=0;
        int dinominator=1;
        int i=0;
        int n=expression.length();
        while(i<n){
            int currNum=0;
            int currDino=0;
            boolean isNeg=(expression.charAt(i)=='-');

            if(expression.charAt(i)=='+' || expression.charAt(i)=='-') i++;
            
            while(i<n && Character.isDigit(expression.charAt(i))){
                int val=expression.charAt(i)-'0';
                currNum=currNum*10+val;
                i++;
            }
            if(expression.charAt(i)=='/') i++;
            if(isNeg) currNum*=-1;

            while(i<n && Character.isDigit(expression.charAt(i))){
                int val=expression.charAt(i)-'0';
                currDino=currDino*10+val;
                i++;
            }
            
            numerator=numerator*currDino + dinominator*currNum;
            dinominator*=currDino;

            int gcd = gcd(Math.abs(numerator), dinominator);

            numerator /= gcd;
            dinominator /= gcd;
            
        }
        return numerator+"/"+dinominator;
    }
    private int gcd(int a , int b){
        if(b==0) return a;
        return gcd(b , a%b);
    }
}
