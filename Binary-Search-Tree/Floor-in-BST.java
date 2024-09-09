import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        if(root==null) return 0;
        int floor=0;

        while(root!=null){
            if(X==root.data){
                floor=root.data;
                return floor;
            }
            else if(X<root.data){
                root=root.left;
            }
            else if(X > root.data){
                floor=root.data;
                root=root.right;
            }
        }
        return floor;
    }
}
