
    Time complexity:
    O(n/2)

    Space complexity:
    O(1)
*****************************************************************************************************************************
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
    public ListNode deleteMiddle(ListNode head) {
        // using Tortoise and Hare Algorithm
        // in which we take two pointers slow and fast and move fast by 2X as slow;
        //so if fast pointers covres all the nodes then on that time slow will be at (n/2) node .which is the middle;
        if(head==null ||head.next==null) return null;
        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=slow.next;
        return head;
    }
}
