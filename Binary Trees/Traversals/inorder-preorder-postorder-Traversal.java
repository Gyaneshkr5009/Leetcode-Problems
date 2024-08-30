/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root ==null) return new ArrayList<>();
        ans.add(inorder(new ArrayList<>() , root));
        ans.add(preorder(new ArrayList<>() , root));
        ans.add(postorder(new ArrayList<>() , root));
        return ans;
    }
    public static List<Integer> inorder(List<Integer> arr ,  TreeNode root){
        if( root ==null) return arr;
        inorder(arr, root.left);
        arr.add(root.data);
        inorder(arr, root.right);
        return arr;
    }
    public static List<Integer> preorder(List<Integer> arr , TreeNode root){
        if(root==null) return arr;
        arr.add(root.data);
        preorder(arr,root.left);
        preorder(arr,root.right);
        return arr;
    }
    public static List<Integer> postorder(List<Integer> arr ,TreeNode root){
        if(root == null) return arr; 
        postorder(arr, root.left);
        postorder(arr,root.right);
        arr.add(root.data);
        return arr;
    }
}
