class Solution {
    public String intToRoman(int nums) {
        String ones[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String twos[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hundreds[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String thns[]={"","M","MM","MMM"};
        return thns[nums/1000]+hundreds[(nums%1000)/100]+twos[(nums%100)/10]+ones[nums%10];
    }
}
