/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> traverseBoundary(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        if(!isLeafNode(root)) ans.add(root.data);
        leftBoundary(root, ans);
        leaf(root , ans);
        rightBoundary(root , ans);
        return ans;
    }
    private static void rightBoundary(TreeNode root , List<Integer> ans){
        TreeNode curr= root.right;
        ArrayList<Integer> temp=new ArrayList<>();
        while(curr!=null){
            if(!isLeafNode(curr)) temp.add(curr.data);
            if(curr.right!=null) curr=curr.right;
            else curr=curr.left;
        }
        for(int i=temp.size()-1; i>=0 ;i--){
            ans.add(temp.get(i));
        }
    }
    private static void leftBoundary(TreeNode root , List<Integer> ans){
        TreeNode curr=root.left;
        while(curr!=null){
            if(!isLeafNode(curr)) ans.add(curr.data);
            if(curr.left!=null) curr=curr.left;
            else curr=curr.right;
        }
    }
    private static void leaf(TreeNode root , List<Integer> ans){
        if(isLeafNode(root)){
            ans.add(root.data);
            return;
        }
        if(root.left!=null) leaf(root.left, ans);
        if(root.right!=null) leaf(root.right, ans);
    }
    private static boolean isLeafNode(TreeNode node){
        return (node.left==null && node.right==null);
    }
}
