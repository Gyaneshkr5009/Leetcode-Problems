import java.util.*;

public class Solution {
    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root , 0));

        TreeMap<Integer, Integer> mpp = new TreeMap<>();

        while(!q.isEmpty()){
            Pair pair=q.poll();
            TreeNode node=pair.node;
            int line=pair.line;

            mpp.put(line , node.val);

            if(node.left!=null) q.offer(new Pair(node.left, line-1));

            if(node.right!=null) q.offer(new Pair(node.right, line+1));
        }

        for(int value:mpp.values()){
            ans.add(value);
        }
        return ans;
    }
}

class Pair{
    TreeNode node;
    int line;
    Pair(TreeNode node , int line){
        this.node=node;
        this.line=line;
    }
}
