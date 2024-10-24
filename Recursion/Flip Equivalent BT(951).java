//time complexity:O(n);
//space complexity:O(n);

//approach => we have to figure out is the nodes in  root1 and root 2 are fliped for finding out;
/*
    ==>Base Case:

    If both trees are null, they are equivalent.
    If one tree is null and the other is not, they are not equivalent.
    If the root values of both trees are not equal, they are not equivalent.

    =>Recursive Check:

    Left and Right Subtrees: Recursively check if the left subtree of root1 is equivalent to either the left or right subtree of root2.
    Right and Left Subtrees: Recursively check if the right subtree of root1 is equivalent to either the right or left subtree of root2.
    Both Conditions: Return true only if both the left and right subtree checks are true.
*/
//******************************************************************(recursion)***************************************************************
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return check(root1 , root2);
    }
    private boolean check(TreeNode root1 , TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null || root1.val!=root2.val) return false;
        return (check(root1.left , root2.left) || check(root1.left , root2.right)) && (check(root1.right , root2.right) || check(root1.right , root2.left));
    }
}
