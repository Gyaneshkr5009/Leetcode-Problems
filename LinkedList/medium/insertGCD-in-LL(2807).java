//time complexity:O(nlogk);
//space complexity:O(log k);
//*****************************************************************************************************
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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode temp=head;
        ListNode prev=temp;
        while(temp!=null && temp.next!=null){
            prev=temp;
            temp=temp.next;
            ListNode newNode=new ListNode(gcd(prev.val , temp.val));
            prev.next=newNode;
            newNode.next=temp;
        }
        return head;
    }
    //a=> prev.val   b=> temp.val;
    private int gcd(int a , int b){
        if(a==0) return b;
        return gcd(b%a , a);
    }
}
