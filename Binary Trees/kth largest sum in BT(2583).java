/*
    BFS Traversal: You use a queue for level-wise traversal (BFS) of the binary tree, where each level's sum is computed.

    Level Sum Calculation: At each level, you sum the values of nodes and then store the sum in a min-heap (priority queue) to track the largest sums.

    Min-Heap (Priority Queue): A priority queue is maintained to store up to k largest level sums. When the heap size exceeds k, the smallest sum is removed, ensuring it always contains the k largest sums.

    Heap Size Check: Before returning the result, a check is done to ensure that the heap size is at least k; if not, -1 is returned, indicating an invalid input or insufficient levels in the tree.

    Edge Case Handling: The solution handles the case where the tree is empty by returning -1 immediately.

Time Complexity:

    O(n log k): O(n) for traversing all nodes of the tree and O(log k) for heap operations since the heap stores at most k elements.

Space Complexity:

    O(k + n): O(k) for the priority queue storing the top k sums and O(n) for the queue used in BFS traversal.
*/
//*************************************************************(BFS Traversal)***********************************************************************
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root==null) return -1;

        // BFS traversal to find out each level sum
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Min heap to store k large elements
        PriorityQueue<Long> pq = new PriorityQueue<>();

        while(!q.isEmpty()){
            long sum=0; 
            int level=q.size();
            // Calculate sum for the current level
            for (int i = 0; i < level; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            pq.offer(sum); //adding the sum to heap;
            if(pq.size()>k){
                pq.poll();
            }
        }
        //if the size of pq is lesser then k return -1 as explainned in question;
        if(pq.size()<k) return -1;
        return pq.poll();
    }
}
