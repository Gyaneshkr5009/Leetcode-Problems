//time complexity:O(n);
//space Complexity:O(n);

//approach is that we try to inorder traversal to sort all values and stored in arrayList 
//after that we apply simple 2sum Array using two pointers
//***************************************************************************************************************************
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
    private ArrayList<Integer> ans=new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        else{
            inorder(root);
            int stp=0 , edp=ans.size()-1;
            while(stp<edp){
                int sum=ans.get(stp)+ans.get(edp);
                if(sum==k) return true;
                else if(sum>k) edp--;
                else stp++;
            }
        }
        return false;
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
}
