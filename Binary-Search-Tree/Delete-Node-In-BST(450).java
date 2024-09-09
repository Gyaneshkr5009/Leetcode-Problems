/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        TreeNode temp=root;

        if(root.val==key) return helper(root);
        while(root!=null){
            if(root.val >key){
                if(root.left!=null && root.left.val==key){
                    root.left = helper(root.left);
                    break;
                }
                else root=root.left;
            }

            else{
                if(root.right!=null && root.right.val==key){
                    root.right=helper(root.right);
                    break;
                }
                else{
                    root=root.right;
                }
            }
        }
        return temp;
    }
    private TreeNode helper(TreeNode root){
        if(root.left==null){
            return root.right;
        }
        else if(root.right==null){
            return root.left;
        }
        TreeNode leftChild=root.left;
        TreeNode lastleft= findLast(root.right);
        lastleft.left=leftChild;
        return root.right;
    }
    private TreeNode findLast(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}


//********************************************************(when,deleting Node and move to left of del Node)*********************************************
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        TreeNode temp=root;

        if(root.val==key) return helper(root);
        while(root!=null){
            if(root.val >key){
                if(root.left!=null && root.left.val==key){
                    root.left = helper(root.left);
                }
                else root=root.left;
            }
            else{
                if(root.right!=null && root.right.val==key){
                    root.right=helper(root.right);
                }
                else{
                    root=root.right;
                }
            }
        }
        return temp;
    }
    private TreeNode helper(TreeNode root){
        if(root.left==null){
            return root.right;
        }
        else if(root.right==null){
            return root.left;
        }
        TreeNode rightChild=root.right;
        TreeNode lastRight= findLast(root.left);
        lastRight.right=rightChild;
        return root.left;
    }
    private TreeNode findLast(TreeNode root){
        while(root.right!=null){
            root=root.right;
        }
        return root;
    }
}

