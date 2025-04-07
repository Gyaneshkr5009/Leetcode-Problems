/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr=head;
        while(curr!=null){
            if(curr.child!=null){
                Node next=curr.next;
                Node child=flatten(curr.child);

                Node tail=child;
                while(tail.next!=null){
                    tail=tail.next;
                }

                //linking curr to child
                curr.next=child;
                child.prev=curr;
                curr.child=null;

                //now cunnexting tail to my next;
                if(next!=null){
                    tail.next=next;
                    next.prev=tail;
                }
                curr=tail;
            }
            curr=curr.next;
        }
        return head;
    }
}
