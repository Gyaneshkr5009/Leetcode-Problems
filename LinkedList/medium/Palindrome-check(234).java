//1st method using Stack
time complexity  O(n)
*********************************************************************************************************************
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
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode temp=head;
        Stack<Integer> st=new Stack<>();
        while(temp!=null){
            st.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(st.peek()!=temp.val) return false;
            st.pop();
            temp=temp.next;
        }
        return true;
    }
}

//2nd approach using Tortoise and Hare algorithm and reverse fuctn
time complexity : O(n)
***************************************************************************************************************************
class Solution {
    public boolean isPalindrome(ListNode head) {
         if(head==null || head.next==null) return true;
         ListNode slow=head;
         ListNode fast=head;
         while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
         }
         ListNode newHead=reverse(slow.next);
         ListNode first=head;
         ListNode second=newHead;
         while(second!=null){
             if(first.val!=second.val){
                 reverse(newHead);
                 return false;
             }
             first=first.next;
             second=second.next;
         }
         reverse(newHead);
         return true;
    }
    public static ListNode reverse(ListNode head)
    {
        // Write your code here.
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr=head , fwd=null , prev=null;
        while(curr!=null){
            fwd=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;
        }
        return prev;
    }
}
