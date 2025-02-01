/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;

        Map<Node , Node> mpp=new HashMap<>(); // node -> copynode;
        Queue<Node> q=new LinkedList<>(); // for bfs traversal;
        mpp.put(node , new Node(node.val));
        q.offer(node); 

        while(!q.isEmpty()){
            Node curr=q.poll();
            for(Node it:curr.neighbors){
                //if neighbor node isn't in mpp then create neighbor with duplicate node;
                if(!mpp.containsKey(it)){
                    mpp.put(it , new Node(it.val));
                    q.offer(it);
                }
                //adding the curr neighbors node to the duplicate curr node neighbor;
                mpp.get(curr).neighbors.add(mpp.get(it));
            }
        }
        return mpp.get(node);
    }
}
