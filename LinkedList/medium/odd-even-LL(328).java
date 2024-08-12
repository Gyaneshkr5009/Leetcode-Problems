/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
*****************************************************************************************************************************************
    Time complexity:
    O(n)

    Space complexity:
    O(1)
//1st approach using three pointer Nodes
      
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode odd=head;
        ListNode even=odd.next;
        ListNode evenHead=even;
        // we traverse until even becomes null for the odd indexex; 1>3>5
        while(even!=null && even.next!=null){ 
            odd.next=even.next; // indicating even indexex element (meanns we are connecting odd with even next which is also odd);
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
}

//2nd approach using two DummyNode(odd and even)
    Time complexity:
    O(n)

    Space complexity:
    O(1)
*********************************************************************************************************************************
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null ||head.next==null) return head;
        ListNode temp=head;
        ListNode even=null;
        ListNode odd=null;
        ListNode odd_temp=null;
        ListNode even_temp=null;
        int cnt=1;
        while(temp!=null){
            if(cnt%2==0){
                if(even==null){
                    even=temp;
                    even_temp=even;
                }
                else{
                    even_temp.next=temp;// storing the path for the next even;
                    even_temp=even_temp.next;// shifting the even node to next even node;
                }
            }
            else{
                if(odd==null){
                    odd=temp;
                    odd_temp=odd;
                    
                }
                else{
                    odd_temp.next=temp;// storing the path for the next odd
                    odd_temp=odd_temp.next;// shifting odd node to the next odd node;
                    
                }
            }
            temp=temp.next;// traversing temp forward;
            cnt++; //incrementing cnt act as index;
        }
        //after getting two different LL (odd and even ) ,so acco to question ;
       // all odd first then all even next , so we add link between tail of the even to null (indicating end of the LL);
        even_temp.next=null;
        // after then we add link between tail of odd LL and start of even LL; 
        odd_temp.next=even;
        return odd;
    }
}
