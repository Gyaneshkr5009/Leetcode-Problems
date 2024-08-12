public class Solution
{
    public static Node sortList(Node head) {
        Node temp=head;
        if(head==null || head.next==null) return head;
        Node Zhead=new Node(-1);
        Node zero =Zhead;
        Node Ohead=new Node(-1);
        Node one=Ohead;
        Node Thead=new Node(-1);
        Node two=Thead;
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=temp;
            }
            else if(temp.data==1){
                one.next=temp;
                one=temp;
            }
            else{
                two.next=temp;
                two=temp;
            }
            temp=temp.next;
        }
        zero.next=(Ohead.next!=null)?Ohead.next:Thead.next;
        one.next=Thead.next;
        two.next=null;
        return Zhead.next;

    }
}
