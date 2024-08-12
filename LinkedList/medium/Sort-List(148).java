
    Time complexity:
    O(n+nlogn+n)

    Space complexity:
    o(n)
  // Brute force Approach
*************************************************************************************************************
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
    public ListNode sortList(ListNode head) {
        ListNode temp=head;
        ArrayList<Integer> arr=new ArrayList<>();
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }
        int index=0;
        Collections.sort(arr);
        temp=head;
        while(temp!=null){
            temp.val=arr.get(index);
            index++;
            temp=temp.next;
        }
        return head;
    }
}
***************************************************************************************************************************
//2nd approach using MergeSort
  

    Time complexity:
    O(nlogn)

    Space complexity:
    o(nlogn)

//prog=>
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        // we use Tortoise and Hare algorithm to find the second mid;
        //but we requires first mid so we initialize fast by one step ;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null &&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;
        ListNode right=mid.next;
        ListNode left=head;
        mid.next=null;
        left=sortList(left);
        right=sortList(right);
        return merge(left ,right);
    }
    // public ListNode findMid(ListNode head){
    //     // we use Tortoise and Hare algorithm to find the second mid;
    //     //but we requires first mid so we initialize fast by one step ;
    //     ListNode slow=head;
    //     ListNode fast=head.next;
    //     while(fast!=null &&fast.next!=null) {
    //         slow=slow.next;
    //         fast=fast.next.next;
    //     }
    //     return slow;
    // }
    public ListNode merge(ListNode left ,ListNode right){
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(left!=null && right!=null){
            if(left.val<=right.val){
                temp.next=left;
                temp=left;
                left=left.next;
            }
            else{
                temp.next=right;
                temp=right;
                right=right.next;
            }
        }
        while(left!=null){
            temp.next=left;
            temp=left;
            left=left.next;
        }
        while(right!=null){
            temp.next=right;
            temp=right;
            right=right.next;
        }
        return dummy.next;
    }
}
