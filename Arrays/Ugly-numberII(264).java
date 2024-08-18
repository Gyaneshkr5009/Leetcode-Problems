Time Complexity: O(n)
Space Complexity: O(n)

  
******************************************************************************************************************
//1st approach

class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly=new int[n];
        ugly[0]=1;
        int idx2=0,idx3=0,idx4=0;
        for(int i=1;i<n;i++){
            int newUgly=Math.min(Math.min(ugly[idx2]*2 , ugly[idx3]*3) , ugly[idx4]*5);
            ugly[i]=newUgly;
            if(newUgly==ugly[idx2]*2) idx2++;
            if(newUgly==ugly[idx3]*3) idx3++;
            if(newUgly==ugly[idx4]*5) idx4++;

        }
        return ugly[n-1];
    }
}

********************************************************************************************************************
  //2nd approach
 Time Complexity:O(n*log(n));


class Solution {
    public int nthUglyNumber(int n) {
        //creating  min pq for keep track of all ugly number;
		PriorityQueue<Long> pq=new PriorityQueue<>();
		//creating set to keep track of numbers that already been visited;
		HashSet<Long> seen=new HashSet<>();
		//add 1(1st ugly number) to min heap and set;
		pq.add(1L);
		seen.add(1L);
		//creating an array containing all prime;
		long[] primes={2,3,5};
		long currUglyNumber=1L;
		//in this loop we create new ugly number by multiplying all prime with heap ugly number;
		for(int i=1 ;i<=n;i++){
			//setting heap peek element to currugly number and also modify our curr ugly number;
			//so when we poll 10th number frm heap we get our 10th ugly number;
			currUglyNumber=pq.poll();
			for(long prime:primes){
				long newUglyNumber=prime*currUglyNumber;
				//hashset loop for the number is present or not;
				if(!seen.contains(newUglyNumber)){
					seen.add(newUglyNumber);
					pq.add(newUglyNumber);
				}
			}
		}
		return (int)currUglyNumber;
    }
}
