//time complexity:O(n+E*n)
//space complexity:O(n)
//*****************************************************************(dfs approach)****************************************************************
class Solution {
    public boolean isBipartite(int[][] graph) {
        //Theory => bipertide graph are the ones that can be color with only 2 colors and all adjacent nodes should have different color .
        //we try to color the graph with 0 and 1 . and if any two adjacent node having same color,means it not a bipertide;


        //if our graph length is 0 then means we dont have the graph to check so we simply return false;
        if(graph==null || graph.length==0) return false;
        int n=graph.length;
        int m=graph[0].length;
        // creating visited array that contains colors . i named it as colors that defines its work;
        int[] colors=new int[n];
        Arrays.fill(colors , -1);//we fill all the cells with -1 initially;

        for(int i=0 ;i< n ;i++){
            if(colors[i]==-1){ // checking through dfs , and initialy we start filling with 0;
                //there may be components of graph that prevent us from checking the whole graph,
                //so insted of if we get true to return true ,we simply check for if any one got false;
                if(dfs(i , 0, graph , colors)==false) return false;
            }
        }
        return true;
    }
    private boolean dfs(int node ,int color, int[][] graph , int[] colors){
        colors[node]=color;

        for(int a:graph[node]){
            //if a node havent visited yet,then we simply add opposite of color of the previous node;
            if(colors[a]==-1){
                if(dfs(a , 1-color , graph , colors)==false) return false;
            }

            //if node already have 0 || 1 means it already visited so we check if the colors are different or not;
            else if(colors[a]==color){
                return false;
            }
        }
        return true;

    }
}

class Pair{
    int node;
    int color;
    Pair(int node , int color){
        this.node=node;
        this.color=color;
    }
}
