

    Time complexity:
    O(n/2)

    Space complexity:
    O(1)

********************************************************************************************************************************************************
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
    public ListNode middleNode(ListNode head) {
        // using Tortoise and Hare Algorithm
        // in which we take two pointers slow and fast and move fast by 2X as slow;
        //so if fast pointers covres all the nodes then on that time slow will be at (n/2) node .which is the middle;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
