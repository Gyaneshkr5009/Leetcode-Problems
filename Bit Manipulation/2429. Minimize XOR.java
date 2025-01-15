class Solution {

    public boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    public int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    public int unsetBit(int x, int bit) {
        return x & ~(1 << bit);
    }

    public int minimizeXor(int num1, int num2) {
        int x = num1;

        int requiredSetBitCount = Integer.bitCount(num2);
        int currSetBitCount = Integer.bitCount(x);

        int bit = 0;

        if(currSetBitCount < requiredSetBitCount) {
            while(currSetBitCount < requiredSetBitCount) {
                if(!isSet(x, bit)) {
                    x = setBit(x, bit);
                    currSetBitCount++;
                }
                bit++;
            }
        } else if(currSetBitCount > requiredSetBitCount) {
            while(currSetBitCount > requiredSetBitCount) {
                if(isSet(x, bit)) {
                    x = unsetBit(x, bit);
                    currSetBitCount--;
                }
                bit++;
            }
        }

        return x;
    }
}
