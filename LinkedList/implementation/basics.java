linked list => are those that have data and a reference to the next node;
// program to convert arr into linked list;
public static Node convertArr2LL(int[] arr ){
	Node head =new Node(arr[0]);
	Node mover=head;
	for(int i=1;i<arr.length; i++){
		Node temp=new Node(arr[i]);
		mover.next=temp;
		mover=temp;
	}
	return head;
}
<**********************************************************************************************************/>

Doubly Linked List => are those that have data and two pointers(reference) to next node and the previous node;
// program to convert arr into doubly linked list;

class Node{
	int data;
	Node next;
	Node back;
	
	Node(int data1,Node next1 ,node prev1){
		this.data=data1;
		this.next=next1;
		this.prev=prev1;
	}
	Node(int data1){
		this.data=data1;
		this.next=null;
		this.prev=null;
	}
}

public static Node convert arr2DLL(int[] arr){
	Node head=new Node(arr[0]);
	Node prev = head;
	for(int i=1 ; i<arr.length;i++){
		Node temp=new Node(arr[i], null ,prev);
		pev.next=temp;
		prev=temp;
	}
	return head;
}	


// deleting head from DLL

public static Node deleteHead(Node head ){
	if(head==null || head.next==null){
		return null;
	}
	Node prev=head;
	head=head.next;
	head.back=null;
	prev.next=null;
	return head;
}

// delete a tail of the DLL

public static Node deleteTail(Node head){
	if(head==null || head.next==null){
            return null;
        }
        Node tail=head; // we are assigning the tail to head and traversing it to the end;
        while(tail.next!=null){
            tail=tail.next;
        }
        // after reaching at the tail we have to cut all the links between tail and 2nd last node;
        Node prevNode=tail.prev; // here 2nd last node becomes prevNode;
        tail.prev=null; //removing prev link with prevNode;
        prevNode.next=null; // removing next link with tail node;
        return head;
    }
//delete a kth element from DLL

public static Node delete(Node head){
	if(head==null ||head.next==null) return null;
	Node temp=head;
	int cnt=0;
	while(temp!=null){
		cnt++;
		if(cnt==k) break;
		temp=temp.next;
	}
	Node prev=temp.back;
	Node front=temp.next;
	if(prev==null &&front==null){
		return null;
	}
	else if(prev==null){
		deleteNode(head);
		return head;
	}
	else if(front ==null){
		deleteTail(head);
		return ;
	}
	prev.next=front;
	front.back=prev;
	temp.next=null;
	temp.back=null;
	return head;
}

//insertion a node in DLL before head;
public static Node insertAtStrt(Node head , int val){
	Node newHead=new Node(val ,head ,null);
	head.back=newHead;
	return newHead;
}

// insertion before tail of the linked list;

public static Node insertBeforeTail(Node head , int val){
	Node tail=head;
	if(head.next==null){
		return insertAtStrt(head,val);
	}
	while(tail.next!=null){
		tail=tail.next;
	}
	Node prev=tail.back;
	Node newNode =new Node(Node head , tail , prev);
	prev.next=newNode;
	tail.back=newNode;
	return head;
}

//insert node before kth element;
private static Node insertBeforeK(Node head , int val ,int k){
	if(k==1){
		return insertAtStrt(head,val);
	}
	Node temp=head;
	int cnt=0;
	while(temp!=null){
		cnt++;
		if(cnt==k) break;
		temp=temp.next;
	}
	Node prev=temp.back;
	Node newNode=new Node(val, temp,prev);
	prev.next=newNode;
	temp.back=newNode;
	return head;
}
		
	

	
		

	
