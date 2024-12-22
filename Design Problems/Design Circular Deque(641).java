class MyCircularDeque {
    private class Node{
        int val;
        Node prev;
        Node next;
        Node(int value){
            this.val=value;
        }
    }
    private int count;
    private int n;
    private Node front;
    private Node rear;

    public MyCircularDeque(int k) {
        this.count=0;
        this.n=k;
        this.front=null;
        this.rear=null;
    }
    
    public boolean insertFront(int value) {
        if(count==n) return false;
        Node newNode=new Node(value);
        if(front==null && rear==null){
            front=rear=newNode;
        }
        else{
            newNode.next=front;
            front.prev=newNode;
            front=newNode;
        }
        count++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(count==n) return false;
        Node newNode=new Node(value);
        if(front==null && rear==null){
            front=rear=newNode;
        }
        else{
            rear.next=newNode;
            newNode.prev=rear;
            rear=newNode;
        }
        count++;
        return true;
    }
    
    public boolean deleteFront() {
        if(count==0) return false;
        if(front==rear) front=rear=null;
        else{
            front=front.next;
            front.prev=null;
        }
        count--;
        return true;
    }
    
    public boolean deleteLast() {
        if(count==0) return false;
        if(front==rear) front=rear=null;
        else{
            rear=rear.prev;
            rear.next=null;
        }
        count--;
        return true;
    }
    
    public int getFront() {
        if(count==0) return -1;
        return front.val;
    }
    
    public int getRear() {
        if(count==0) return -1;
        return rear.val;
    }
    
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count==n;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
