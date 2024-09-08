//time complexity:O(n);
//space complexity:O(k);
//******************************************************************************************************
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr=head;
        //finding length of LL;
        int length=0;
        while(curr!=null){
            length++;
            curr=curr.next;
        }
        curr=head;
        ListNode[] ans=new ListNode[k];
        if(head==null) return ans;
        int nodeLength=length/k;
        int remainderNode=length%k;
        ListNode prev=null;

        for(int i=0 ;i<k && curr!=null;i++){
            ans[i]=curr;

            for(int j=0 ;j< nodeLength+ (remainderNode>0 ?1:0) ; j++){
                prev=curr;
                curr=curr.next;
            }
            if(prev!=null) prev.next=null;
            remainderNode--;
        }
        return ans;
    }
}
