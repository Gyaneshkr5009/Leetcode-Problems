//**************************************(brute force using priortyQueue)***********************************************************
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int level=q.size();
            for(int i=0;i<level ;i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                pq.offer(q.poll().val);
            }
        }
        while(k>1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}


//*********************************************************(optimal approach using inorder)********************************************************
//time complexity:O(n);
//space complexity:O(n);


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
    ArrayList<Integer> incArr=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        inorder(root);
        return incArr.get(k-1);
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        incArr.add(root.val);
        inorder(root.right);
    }
}
