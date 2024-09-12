
//*************************************************************************************************************************************
// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        return helper(root).maxSize;
    }
    static NodeValue helper(Node root){
        //node is null then return min as max int value and same for the max as min int value;
        if(root==null) return new NodeValue(Integer.MAX_VALUE , Integer.MIN_VALUE , 0);
        
        //getting value from left and right of bst;
        NodeValue left=helper(root.left);
        NodeValue right=helper(root.right);
        
        if(left.maxNode < root.data && right.minNode >root.data){
            return new NodeValue(Math.min(root.data , left.minNode) , Math.max(root.data , right.maxNode) , left.maxSize+right.maxSize+1);
        }
        
        //otherwise
        return new NodeValue(Integer.MIN_VALUE , Integer.MAX_VALUE , Math.max(left.maxSize , right.maxSize));
    }
    
}
class NodeValue{
    int maxNode , minNode , maxSize;
    NodeValue(int minNode , int maxNode ,int maxSize){
        this.minNode=minNode;
        this.maxNode=maxNode;
        this.maxSize=maxSize;
    }
}
