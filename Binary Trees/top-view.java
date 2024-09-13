class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(0,root));
        
        
        // TreeMap to store the top view nodes
        // based on their vertical positions
        TreeMap<Integer ,Integer> mpp=new TreeMap<>();
        
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int line=curr.line;
            Node node=curr.node;
            
            if(!mpp.containsKey(line)) mpp.put(line , node.data);
            
            if(node.left!=null) q.offer(new Pair(line-1 , node.left));
            
            if(node.right!=null) q.offer(new Pair(line+1 , node.right));
        }
        
        // Transfer values from the
        // map to the result list
        for(Integer value:mpp.values()){
            ans.add(value);
        }
        return ans;
    }
    
}

class Pair{
    Node node;
    int line;
    
    Pair(int line , Node node){
        this.node=node;
        this.line=line;
    }
}
