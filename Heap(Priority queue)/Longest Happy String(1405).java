/*
    Key Approach:

    Use a Priority Queue:
        Store the characters ('a', 'b', 'c') and their frequencies in a max-heap so that you always work with the most frequent character first.

    Greedy Selection:
        Always append the most frequent character unless it has already been added twice consecutively (this prevents invalid sequences).
        If the most frequent character cannot be used (due to the consecutive rule), use the second most frequent character.

    Backtracking:
        Decrease the frequency of the character used, and if it still has occurrences left, add it back to the heap.

    Edge Case Handling:
        Handle the case where no valid next character is available by checking the second top character in the heap.

Complexity:

    Time Complexity: O(n log 3) ≈ O(n) (since the heap only stores 3 elements at most, log 3 is constant).
    Space Complexity: O(1) (for storing the characters and counts).
*/

//*****************************************************************************************************************************************************************
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        //making a max PriorityQueue to store character and their occurence;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> y.freq-x.freq);

        if(a>0){
            pq.offer(new Pair(a , 'a')); // storing a with occurance given;
        }
        if(b>0){
            pq.offer(new Pair(b, 'b'));
        }
        if(c>0){
            pq.offer(new Pair(c, 'c'));
        }

        StringBuilder result=new StringBuilder();

        while(!pq.isEmpty()){
            //we pull out the max pq top element and second top element;
            Pair pair=pq.poll();
            int currCnt=pair.freq;
            char currChar=pair.ch;

            //if 2 char are already append from the top most one then do operations on 2nd one;
            if(result.length()>=2 && result.charAt(result.length()-1)==currChar && result.charAt(result.length()-2)==currChar){
                if(pq.isEmpty()) break;

                Pair next=pq.poll();
                int nextCnt=next.freq;
                char nextChar=next.ch;

                result.append(nextChar);
                nextCnt--;
                if(nextCnt>0) pq.offer(new Pair(nextCnt , nextChar));
            }

            //if result is Empty then simply append the one char freq from the top pq char;
            else {
                currCnt--;
                result.append(currChar);

            }
            //if freq of largest freq char still > 0 then re offer to pq;
            if(currCnt>0){
                pq.offer(new Pair(currCnt , currChar));
            }
        }
        return result.toString();
    }
}
class Pair{
    int freq;
    char ch;
    Pair(int a, char c){
        this.freq=a;
        this.ch=c;
    }
}
