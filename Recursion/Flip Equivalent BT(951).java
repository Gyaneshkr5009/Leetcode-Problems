//time complexity:O(n);
//space complexity:O(n);

//approach => we have to figure out is the nodes in  root1 and root 2 are fliped for finding out;
/*
    step1 : we have to check for the left one first through recursion 
    step 2: check for the right side if both return true else return false;
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
