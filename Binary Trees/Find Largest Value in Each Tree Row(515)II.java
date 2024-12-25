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
    public int minimumOperations(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        int totalSwap=0;
        while(!q.isEmpty()){
            int size=q.size();
            int[] minSwapSort=new int[size];
            int idx=0;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                minSwapSort[idx++]=node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            if(size>=2){
                int numSwap=minSwapToSort(minSwapSort);
                totalSwap+=numSwap;
            } 
        }
        return totalSwap;
    }

    private int minSwapToSort(int[] arr){
        int n = arr.length;
        int swaps = 0;

        // Pair values with their original indices
        int[][] indexedArr = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexedArr[i][0] = arr[i]; // value
            indexedArr[i][1] = i;     // original index
        }

        // Sort by value
        Arrays.sort(indexedArr, Comparator.comparingInt(a -> a[0]));

        // Visited array to track processed indices
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            // Skip if already visited or in the correct position
            if (visited[i] || indexedArr[i][1] == i) continue;

            // Calculate the size of the cycle
            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = indexedArr[j][1]; // Move to the next index in the cycle
                cycleSize++;
            }

            // Add swaps needed for this cycle
            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }
}
