/*
    Key Approach:

    Convert the Number to a Character Array:
        We start by converting the integer into a character array to manipulate the digits easily.

    Right-Max Array:
        Create an array maxRight[] to store the index of the largest digit that appears to the right of each digit.
        Traverse from the end of the array to the start, keeping track of the maximum digit found so far. This will allow us to know for each digit if there is a larger digit to its right that we can swap with.

    Find the First Swap Opportunity:
        As we traverse the number from the start, if the current digit is smaller than the largest digit to its right (stored in maxRight[]), we swap these digits to make the number as large as possible.

    One Swap:
        Since we are allowed only one swap, after finding the first opportunity to swap, we perform the swap and return the result.

Complexity:

    Time Complexity: O(n), where n is the number of digits in the number. We traverse the number twice (once to fill maxRight[] and once to find the swap opportunity).
    Space Complexity: O(n), due to the maxRight[] array and the character array.
*/
//*********************************************************************************************************************************************
class Solution {
    public int maximumSwap(int num) {
        char[] str=Integer.toString(num).toCharArray(); // this will create a char array;
        int n=str.length;

        int[] maxRight=new int[n]; //for storing the idx of the max element that appears to the right of the curr idx.
        maxRight[n-1]=n-1; //last element does have right element so its largest value is itself;

        //traversing from the end and storing right max element;
        for(int i=n-2 ; i>=0 ;i--){
            int rightMaxIdx=maxRight[i+1];   //right Max element index;
            int rightMaxNum=str[rightMaxIdx];

            //if curr digit is smaller then the rightMax num simple put index into the curr one else i;
            maxRight[i] = (str[i] > rightMaxNum) ? i : rightMaxIdx;
        }

        //Traverse from the start, and if we find the largest element, swap it and break, as only one swap is allowed.
        for(int i=0;i< n ;i++){
            int maxRightIdx=maxRight[i];
            int maxRightNum=str[maxRightIdx];

            //swaping 
            if(str[i] < maxRightNum){
                char temp=str[i];
                str[i]=str[maxRightIdx];
                str[maxRightIdx]=temp;
                break;
            }
        }

        return Integer.valueOf(new String(str));
    }
}
