Time Complexity: O(N) The code traverses the entire linked list at least once, where 'N' is the number of nodes in the list. Therefore, the time complexity is linear, O(N).

Space Complexity: O(N) The code uses a hashmap/dictionary to store encountered nodes, which can take up to O(N) additional space, where ‘N' is the number of nodes in the list. Hence, the space complexity is O(N) due to the use of the map to track nodes.
*******************************************************************************************************************************************************************
//1st approach using HashMap

  
/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

//Function should return the length of the loop in LL.

class Solution
{
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        HashMap<Node,Integer> mpp=new HashMap<>();
        Node temp=head;
        int timer=1;
        while(temp!=null){
            if(mpp.containsKey(temp)){
                return timer-mpp.get(temp);
            }
            else{
                mpp.put(temp,timer++);
            }
            temp=temp.next;
        } 
        return 0;
    }
}

****************************************************************************************************************************************************
//2nd approach using tortoise and hare algorithm

class Solution
{
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
         Node slow = head;
        Node fast = head;
        int cnt = 0;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = slow.next;
                cnt = 1;
                while(slow!=fast){
                   slow = slow.next; 
                   cnt++;
                }
                break;
            }
        }
        return cnt;
    }
    
}
